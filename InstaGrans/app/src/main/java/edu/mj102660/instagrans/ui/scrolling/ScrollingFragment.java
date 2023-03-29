package edu.mj102660.instagrans.ui.scrolling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.databinding.FragmentScrollingBinding;

public class ScrollingFragment extends Fragment {

    private FragmentScrollingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ScrollingViewModel scrollingViewModel =
                new ViewModelProvider(this).get(ScrollingViewModel.class);

        binding = FragmentScrollingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textScrolling;
        //scrollingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        textView.setText(R.string.large_text);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}