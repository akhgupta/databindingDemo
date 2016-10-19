package com.akhlgupta.databindingdemo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorViewModelTest {

    @Test
    public void testShouldNotBeAbleToSetMoreThanMaxIDR() throws Exception {
        CalculatorViewModel calculatorViewModel = new CalculatorViewModel(200d, 1d);
        calculatorViewModel.setIdrAmount(String.valueOf(CalculatorViewModel.MAX_AMOUNT_IDR + 100));
        assertTrue(Double.valueOf(calculatorViewModel.getIdrAmount()) == 200d);
    }

    @Test
    public void testShouldBeAbleToSetIDR() throws Exception {
        CalculatorViewModel calculatorViewModel = new CalculatorViewModel(200d, 1d);
        calculatorViewModel.setIdrAmount(String.valueOf(CalculatorViewModel.MAX_AMOUNT_IDR - 100));
        assertTrue(Double.valueOf(calculatorViewModel.getIdrAmount()) == CalculatorViewModel.MAX_AMOUNT_IDR - 100);
    }

    @Test
    public void setIdrAmount() throws Exception {

    }

    @Test
    public void testShouldNotBeAbleToSetMoreThanMaxINR() throws Exception {
        CalculatorViewModel calculatorViewModel = new CalculatorViewModel(200d, 1d);
        calculatorViewModel.setInrAmount(String.valueOf(CalculatorViewModel.MAX_AMOUNT_INR + 100));
        assertTrue(Double.valueOf(calculatorViewModel.getInrAmount()) == 1d);
    }

    @Test
    public void setInrAmount() throws Exception {

    }

    @Test
    public void testParseDouble() throws Exception {
        CalculatorViewModel calculatorViewModel = new CalculatorViewModel(200d, 1d);
        assertEquals((Double) 100.50d,calculatorViewModel.getFormatedDouble("100.5000"));
        assertEquals((Double) 100.50d,calculatorViewModel.getFormatedDouble("100.50"));
        assertEquals((Double) 100.50d,calculatorViewModel.getFormatedDouble("100.5"));
        assertEquals((Double) 100.00d,calculatorViewModel.getFormatedDouble("100"));

    }
}