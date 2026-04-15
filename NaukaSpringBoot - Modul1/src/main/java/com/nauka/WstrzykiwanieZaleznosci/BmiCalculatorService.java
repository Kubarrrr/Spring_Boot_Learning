package com.nauka.WstrzykiwanieZaleznosci;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BmiCalculatorService {
    public BmiCalculateResponse calculateBmi(Double weight, Double heightInCm) {
        double heightInMeters = heightInCm / 100;
        double bmi = weight / Math.pow(heightInMeters, 2);

        BmiNote bmiNote;
        if (bmi > 25) {
            bmiNote = BmiNote.NADWAGA;
        } else if (bmi <= 25 && bmi >= 20) {
            bmiNote = BmiNote.OK;
        } else {
            bmiNote = BmiNote.NIEDOWAGA;
        }

        System.out.println("BMI: " + bmi + " ==> " + bmiNote);

        return new BmiCalculateResponse(bmi, bmiNote);
    }
}
