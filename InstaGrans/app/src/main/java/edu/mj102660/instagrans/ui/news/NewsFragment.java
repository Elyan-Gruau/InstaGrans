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

import edu.mj102660.instagrans.databinding.FragmentNewsBinding;
import edu.mj102660.instagrans.ui.news.adapter.NewsAdapter;
import edu.mj102660.instagrans.ui.news.adapter.NewsList;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        NewsViewModel newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNews;
        newsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        ListView listView = binding.listNews;
        NewsList newsList = new NewsList();

        NewsAdapter newsAdapter = new NewsAdapter(newsList, this);
        listView.setAdapter(newsAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}