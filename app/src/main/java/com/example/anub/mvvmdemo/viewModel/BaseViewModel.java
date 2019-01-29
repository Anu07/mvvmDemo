package com.example.anub.mvvmdemo.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

class BaseViewModel extends AndroidViewModel implements BaseView {


    public BaseViewModel(@NonNull Application application) {
        super(application);
    }




    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String localizedMessage) {

    }
}
