package edu.mj102660.instagrans.ui.discover;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DiscoverViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DiscoverViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Discover");
    }

    public LiveData<String> getText() {
        return mText;
    }
}