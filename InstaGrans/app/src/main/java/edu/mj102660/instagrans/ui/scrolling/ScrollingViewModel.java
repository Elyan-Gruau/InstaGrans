package edu.mj102660.instagrans.ui.scrolling;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.mj102660.instagrans.R;

public class ScrollingViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ScrollingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}