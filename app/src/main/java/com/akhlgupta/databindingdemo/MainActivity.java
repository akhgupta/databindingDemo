package com.akhlgupta.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.akhlgupta.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainView{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final CalculatorViewModel calculatorViewModel = new CalculatorViewModel(0d,0d);
        MainPresenter mainPresenter = new MainPresenter(this);
        binding.setViewmodel(calculatorViewModel);
        binding.setPresenter(mainPresenter);
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }
}