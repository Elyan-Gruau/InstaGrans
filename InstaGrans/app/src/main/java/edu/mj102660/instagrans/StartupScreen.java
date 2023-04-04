package edu.mj102660.instagrans;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;
import edu.mj102660.instagrans.grans.dish.Dish;
import edu.mj102660.instagrans.network.HttpHandler;
import edu.mj102660.instagrans.network.WebServiceConnexion;

import android.os.AsyncTask;

public class StartupScreen extends AppCompatActivity {

    private final String hostIp = WebServiceConnexion.getIP();
    ProgressDialog pDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_screen);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.instagrans);
        mp.setVolume((float) 1, (float) 1);
        mp.start();


        //buttonDisplayed.replace(btnFondu,false);
        ImageView logo = findViewById(R.id.logo);
        TextView text = findViewById(R.id.textView);

        logo.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);
        logo.startAnimation(AnimationUtils.loadAnimation(
                StartupScreen.this, R.anim.fade));
        text.startAnimation(AnimationUtils.loadAnimation(
                StartupScreen.this, R.anim.fade_text));
        logo.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);



        Intent intent = new Intent(this, MainActivity.class);
        Handler handler = new Handler();

        //Fetch les données du JSon
        new GetGrannies().execute();


        handler.postDelayed(() -> startActivity(intent), 3000);
    }


    /**
     * Tache asynchrone pour fetch
     */
    public class GetGrannies extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(StartupScreen.this);
            pDialog.setMessage("Connexion en cours...");
            pDialog.setCancelable(false);
            //pDialog.show(); // Désactiver car génant lors du démarage.

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


                        //Récupération des attributs
                        String name= c.getString("name");
                        int age = c.getInt("age");
                        String location = c.getString("location");
                        String desc = c.getString("desc");
                        String urlPicture = c.getString("urlPicture");
                        double score = c.getDouble("score");
                        double price = c.getDouble("price");

                        //On créer l'objet, on applique tout les attributs
                        Granny granny = new Granny();
                        granny.setName(name);
                        granny.setAge(age);
                        granny.setLocation(location);
                        granny.setDesc(desc);
                        granny.setScore(score);
                        granny.setPrice(price);
                        granny.setUrlPicture(urlPicture);


                        //Récupération de l'array
                        JSONArray dishesArray = c.getJSONArray("dishes");
                        for (int j =0; j<dishesArray.length();j++){

                            //Récupération de l'objet Dish
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

                        //Ajout de la granny au SINGLETON
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
        /*
         if (pDialog.isShowing())
                pDialog.dismiss();
            ArrayList<String> list = new ArrayList<String>();
            for(int i=0;i<grannies.size();i++)
                list.add(grannies.get(i).toString());
         */

        }
    }

}