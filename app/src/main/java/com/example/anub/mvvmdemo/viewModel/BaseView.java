package com.example.anub.mvvmdemo.viewModel;

public interface BaseView {

   void showProgress();

   void hideProgress();

   void showError(String localizedMessage);
}
