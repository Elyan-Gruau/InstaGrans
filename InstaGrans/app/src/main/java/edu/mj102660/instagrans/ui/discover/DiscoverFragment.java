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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.mj102660.instagrans.NotificationBuilder;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.databinding.FragmentDiscoverBinding;
import edu.mj102660.instagrans.search.SearchResultActivity;

public class DiscoverFragment extends Fragment {

    private FragmentDiscoverBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

   

        binding = FragmentDiscoverBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        ImageButton searchButton = root.findViewById(R.id.search_button);
        EditText searchText = root.findViewById(R.id.search_bar);


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

        // Lancement de la notification
        NotificationBuilder notificationBuilder = new NotificationBuilder(this.getActivity());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Test Channel", "Test Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = this.getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Button test = root.findViewById(R.id.testNotification);
        test.setOnClickListener(view -> {
            notificationBuilder.buildNotification("A", "B");
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}