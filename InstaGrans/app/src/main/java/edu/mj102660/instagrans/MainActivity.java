package edu.mj102660.instagrans;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = findViewById(R.id.nav_view);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);




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








}