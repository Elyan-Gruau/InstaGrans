package edu.mj102660.instagrans.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.MainActivity;
import edu.mj102660.instagrans.ProfileActivity;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.grans.Granny;


public class SearchResultActivity extends AppCompatActivity implements ClickableActivity {

    ImageButton backButton;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        String request = intent.getStringExtra(getString(R.string.SEARCH));

        ArrayList<Granny> grans = GranSearch.requestResult(request);

        ResultAdapter adapter = new ResultAdapter(this, grans);

        ListView listResults = findViewById(R.id.search_results);

        listResults.setAdapter(adapter);

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