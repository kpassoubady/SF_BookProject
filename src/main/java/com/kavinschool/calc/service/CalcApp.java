package com.kavinschool.calc.service;

public class CalcApp {
    private CalculatorService calcService;

    public void setCalculatorService(CalculatorService calcService){
        this.calcService = calcService;
    }

    public double add(double input1, double input2){
        return calcService.add(input1, input2);
    }

    public double subtract(double input1, double input2){
        return calcService.sub(input1, input2);
    }

    public double multiply(double input1, double input2){
        return calcService.mul(input1, input2);
    }

    public double divide(double input1, double input2){
        return calcService.div(input1, input2);
    }
}
