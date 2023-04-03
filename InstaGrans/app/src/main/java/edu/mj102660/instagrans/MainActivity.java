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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import edu.mj102660.instagrans.databinding.ActivityMainBinding;
import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.network.HttpHandler;
import edu.mj102660.instagrans.search.SearchResultActivity;

public class MainActivity extends AppCompatActivity implements ClickableActivity {

    private ActivityMainBinding binding;

    BottomNavigationView navView;
    ImageButton searchButton;
    EditText searchText;
    ProgressDialog pDialog ;
    private ListView lv;

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

        news();
        cart();


        //String json = getJsonString("http://localhost:8080/getGrannies");
        new GetGrannies().execute();


    }


    private void news() {

    }


    private void cart() {

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
        ArrayList<Granny> grannies;
        ArrayList<String> maListe;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Connexion en cours...");
            pDialog.setCancelable(false);
            pDialog.show();

        }



        @Override
        // appeler automatiquement après onPreExecute
        protected Void doInBackground(Void... params) {

            for (int progress = 0; progress  < 1000000000; progress++){
                // Ne fait rien mais fait juste passer du temps
            }
            HttpHandler handler = new HttpHandler();


            String jsonStr = handler.makeServiceCall("http://192.168.0.35:8080/getGrannies");

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    //Récupérer l'array
                    JSONArray grannyList = jsonObj.getJSONArray("");

                    // pour chaque element de l'array
                    for (int i = 0; i < grannyList.length(); i++) {
                        JSONObject c = grannyList.getJSONObject(i);

                        String name= c.getString("name");
                        int age = c.getInt("age");
                        String location = c.getString("location");
                        String desc = c.getString("desc");
                        String urlPicture = c.getString("urlPicture");
                        double score = c.getDouble("price");
                        double price = c.getDouble("price");


                        // récupération  geometry objet
                        //JSONObject geometry = c.getJSONObject("granny");

                        //String geo = geometry.getString("coordinates");


                        Granny granny = new Granny();
                        granny.setName(name);
                        granny.setAge(age);
                        granny.setLocation(location);
                        granny.setDesc(desc);
                        granny.setScore(score);
                        granny.setPrice(price);
                        granny.setUrlPicture(urlPicture);

                        grannies.add(granny);
                    }

                } catch (final JSONException e) {
                    System.out.println("Erreur JSON " + e.getMessage());

                }
            } else {
                System.out.println( "Probleme connexion ");
            }

            return null;
        }

    }

}