package com.akhlgupta.databindingdemo;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.text.DecimalFormat;

public class CalculatorViewModel extends BaseObservable {
    public static final Double MAX_AMOUNT_INR = 10000d;
    public static final int INR_TO_IDR_CONVERSION_RATE = 200;
    public static final Double MAX_AMOUNT_IDR = MAX_AMOUNT_INR * INR_TO_IDR_CONVERSION_RATE;
    public Double idrAmount;
    public Double inrAmount;

    public CalculatorViewModel(Double idrAmount, Double inrAmount) {
        this.idrAmount = idrAmount;
        this.inrAmount = inrAmount;
    }

    @Bindable
    public String getIdrAmount() {
        return String.valueOf(idrAmount);
    }

    @Bindable
    public void setIdrAmount(String idrAmount) {
        if (idrAmount.isEmpty())
            return;
        Double idr = getFormatedDouble(idrAmount);
        if (idr < MAX_AMOUNT_IDR) {
            Double inrAmount = idr / INR_TO_IDR_CONVERSION_RATE;
            this.idrAmount = idr;
            this.inrAmount = inrAmount;
            notifyPropertyChanged(BR.inrAmount);
        }
        else {
            this.idrAmount=MAX_AMOUNT_IDR;
            notifyPropertyChanged(BR.idrAmount);
        }
    }

    public Double getFormatedDouble(String idrAmount) {
        DecimalFormat df = new DecimalFormat("#.00");
        Double idr = Double.valueOf(idrAmount);
        idr = Double.valueOf(df.format(idr));
        return idr;
    }

    @Bindable
    public String getInrAmount() {
        return String.valueOf(inrAmount);
    }

    @Bindable
    public void setInrAmount(String inrAmount) {
        if (inrAmount.isEmpty())
            return;

        Double inr = getFormatedDouble(inrAmount);
        if (inr < MAX_AMOUNT_INR) {
            Double idrAmount = inr * INR_TO_IDR_CONVERSION_RATE;
            this.inrAmount = inr;
            this.idrAmount = idrAmount;
            notifyPropertyChanged(BR.idrAmount);
        }
        else {
            this.idrAmount=MAX_AMOUNT_INR;
            notifyPropertyChanged(BR.inrAmount);
        }
    }
}