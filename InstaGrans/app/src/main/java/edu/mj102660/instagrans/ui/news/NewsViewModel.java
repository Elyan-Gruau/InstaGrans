package edu.mj102660.instagrans.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NewsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("News");
    }

    public LiveData<String> getText() {
        return mText;
    }
}