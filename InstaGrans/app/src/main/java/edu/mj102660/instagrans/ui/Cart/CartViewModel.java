package edu.mj102660.instagrans.ui.Cart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CartViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cart");
    }

    public LiveData<String> getText() {
        return mText;
    }
}