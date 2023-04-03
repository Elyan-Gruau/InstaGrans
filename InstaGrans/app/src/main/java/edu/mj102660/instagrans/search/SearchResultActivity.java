package edu.mj102660.instagrans.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.MainActivity;
import edu.mj102660.instagrans.ProfileActivity;
import edu.mj102660.instagrans.R;


public class SearchResultActivity extends AppCompatActivity implements ClickableActivity {

    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(intent);
        });
    }

    @Override
    public void onClickGranny(int index) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        intent.putExtra(getString(R.string.GRANNY), index);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}