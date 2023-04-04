package edu.mj102660.instagrans;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import edu.mj102660.instagrans.databinding.ActivityMainBinding;
import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;
import edu.mj102660.instagrans.grans.dish.Dish;
import edu.mj102660.instagrans.network.HttpHandler;
import edu.mj102660.instagrans.profile.ProfileActivity;

public class MainActivity extends AppCompatActivity implements ClickableActivity {

    private ActivityMainBinding binding;

    BottomNavigationView navView;
    ImageButton searchButton;
    EditText searchText;
    ProgressDialog pDialog ;
    private ListView lv;
    private final String hostIp = "172.19.20.130";

    Intent intent;
    ArrayList<Granny> grannies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = findViewById(R.id.nav_view);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);


        //String json = getJsonString("http://localhost:8080/getGrannies");
        new GetGrannies().execute();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onClickGranny(int index) {

        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        intent.putExtra(getString(R.string.GRANNY), index);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }






    /**
     * Tache asynchrone
     */
    public class GetGrannies extends AsyncTask<Void,Void,Void> {
        ArrayList<Granny> granniesL = new ArrayList<>();
        ArrayList<String> maListe = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Connexion en cours...");
            pDialog.setCancelable(false);
            //pDialog.show();

        }



        @Override
        // appeler automatiquement après onPreExecute
        protected Void doInBackground(Void... params) {

            for (int progress = 0; progress  < 1000000000; progress++){
                // Ne fait rien mais fait juste passer du temps
            }
            HttpHandler handler = new HttpHandler();

            try {
                System.out.println(InetAddress.getLocalHost());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            //192.168.0.35
            String jsonStr = handler.makeServiceCall("http://"+hostIp+":8080/getGrannies");

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    //Récupérer l'array
                    JSONArray grannyList = jsonObj.getJSONArray("grannies");

                    // pour chaque element de l'array
                    for (int i = 0; i < grannyList.length(); i++) {
                        JSONObject c = grannyList.getJSONObject(i);

                        String name= c.getString("name");
                        int age = c.getInt("age");
                        String location = c.getString("location");
                        String desc = c.getString("desc");
                        String urlPicture = c.getString("urlPicture");
                        double score = c.getDouble("score");
                        double price = c.getDouble("price");


                        // récupération  geometry objet
                        //JSONObject geometry = c.getJSONObject("granny");

                        //String geo = geometry.getString("coordinates");


                        Granny granny = new Granny();
                        //System.out.println("NAME: "+name);
                        granny.setName(name);
                        granny.setAge(age);
                        granny.setLocation(location);
                        granny.setDesc(desc);
                        granny.setScore(score);
                        granny.setPrice(price);
                        granny.setUrlPicture(urlPicture);

                        JSONArray dishesArray = c.getJSONArray("dishes");
                        for (int j =0; j<dishesArray.length();j++){
                            JSONObject d = dishesArray.getJSONObject(j);
                            Dish dish = new Dish();
                            dish.setName(d.getString("name"));
                            //System.out.println("name  "+d.getString("name"));
                            dish.setNote(d.getString("note"));
                            dish.setUrlImage(d.getString("urlImage"));
                            dish.setPrepTime(d.getString("prepTime"));
                            dish.setPrepMinute(d.getInt("prepMinute"));
                            granny.addDish(dish);
                        }

                        Grans.getInstance().add(granny);
                    }
                    System.out.println("Grannies Fetched.");

                } catch (final JSONException e) {
                    System.out.println("Erreur JSON " + e.getMessage());

                }
            } else {
                System.out.println( "Probleme connexion ");
            }

            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (pDialog.isShowing())
                pDialog.dismiss();
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<Grans.getInstance().size();i++)
                list.add(Grans.getInstance().get(i).toString());


            // UTILER UN ADAPTER PLUS JOLI!!!
            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, list);

            //lv.setAdapter(adapter);
        }

    }

}