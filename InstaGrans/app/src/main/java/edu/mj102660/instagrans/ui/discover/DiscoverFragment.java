package edu.mj102660.instagrans.ui.discover;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.NotificationBuilder;
import edu.mj102660.instagrans.databinding.FragmentDiscoverBinding;
import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;
import edu.mj102660.instagrans.search.GranSearch;
import edu.mj102660.instagrans.search.ResultAdapter;
import edu.mj102660.instagrans.search.SearchResultActivity;
import edu.mj102660.instagrans.ui.discover.adapter.DiscoverAdapter;

public class DiscoverFragment extends Fragment implements ClickableActivity {

    private FragmentDiscoverBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

   

        binding = FragmentDiscoverBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        ImageButton searchButton = root.findViewById(R.id.search_button);
        EditText searchText = root.findViewById(R.id.search_bar);

        ListView listResults = root.findViewById(R.id.listGrannies);

        DiscoverAdapter adapter = new DiscoverAdapter(this);
        listResults.setAdapter(adapter);


        searchButton.setOnClickListener(view -> {

            String request = searchText.getText().toString();

            if(request.equals("")){
                Toast.makeText(root.getContext(), getString(R.string.search_empty), Toast.LENGTH_LONG).show();
            }
            else{
                Intent intent = new Intent(root.getContext(), SearchResultActivity.class);
                intent.putExtra(getString(R.string.SEARCH), request);
                startActivity(intent);
            }

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClickGranny(int index) {

    }
}