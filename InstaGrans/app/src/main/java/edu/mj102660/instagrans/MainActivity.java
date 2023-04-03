package edu.mj102660.instagrans;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import edu.mj102660.instagrans.databinding.ActivityMainBinding;
import edu.mj102660.instagrans.search.SearchResultActivity;

public class MainActivity extends AppCompatActivity implements ClickableActivity {

    private ActivityMainBinding binding;

    BottomNavigationView navView;
    ImageButton searchButton;
    EditText searchText;

    Intent intent;

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

    }




    private void news(){

    }


    private void cart(){

    }

    @Override
    public void onClickGranny(int index) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        intent.putExtra(getString(R.string.GRANNY), index);
        startActivity(intent);
    }

    private String getJsonString(String urlQueryString) throws IOException {
        String json = null;
        URL url = new URL(urlQueryString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("charset", "utf-8");
        connection.connect();
        InputStream inStream = connection.getInputStream();
        json = streamToString(inStream); // input stream to string
        return json;
    }

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}