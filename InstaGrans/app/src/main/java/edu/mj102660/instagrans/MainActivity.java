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
        home();
        cart();

    }


    private void news(){

    }

    private void home(){

        searchButton = findViewById(R.id.search_button);
        searchText = findViewById(R.id.search_bar);

        String request = searchText.getText().toString();

        searchButton.setOnClickListener(view -> {
            intent = new Intent(getApplicationContext(), SearchResultActivity.class);
            intent.putExtra(getString(R.string.SEARCH), request);
            startActivity(intent);
        });

    }

    private void cart(){

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