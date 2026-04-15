package com.nauka.WstrzykiwanieZaleznosci;

public class BmiCalculateRequest {
    private final double weight;
    private final double height;

    public BmiCalculateRequest(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}
