package com.akhlgupta.databindingdemo;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void clearFields(CalculatorViewModel viewModel) {
        viewModel.setInrAmount("0");
        viewModel.setIdrAmount("0");
        mainView.showToast("Cleared all fields");
    }
}