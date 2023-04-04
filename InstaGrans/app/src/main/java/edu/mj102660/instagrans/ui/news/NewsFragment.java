package edu.mj102660.instagrans.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.databinding.FragmentNewsBinding;
import edu.mj102660.instagrans.ui.news.adapter.NewsAdapter;
import edu.mj102660.instagrans.ui.news.adapter.NewsList;

public class NewsFragment extends Fragment implements ClickableActivity {

    private FragmentNewsBinding binding;

    NewsList newsList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = binding.listNews;
        newsList = new NewsList(root);

        NewsAdapter newsAdapter = new NewsAdapter(this, newsList);
        listView.setAdapter(newsAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        newsList = null;
    }

    @Override
    public void onClickGranny(int index) {

    }
}