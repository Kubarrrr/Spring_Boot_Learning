package com.nauka.WstrzykiwanieZaleznosci;

public class BmiCalculateResponse {
    private double bmi;
    private BmiNote bmiNote;

    public BmiCalculateResponse(double bmi, BmiNote bmiNote) {
        this.bmi = bmi;
        this.bmiNote = bmiNote;
    }
    public double getBmi() {
        return bmi;
    }

    public BmiNote getBmiNote() {
        return bmiNote;
    }
}
