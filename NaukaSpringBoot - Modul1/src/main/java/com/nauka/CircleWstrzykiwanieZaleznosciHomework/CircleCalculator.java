package com.nauka.CircleWstrzykiwanieZaleznosciHomework;

import org.springframework.stereotype.Component;

@Component
public class CircleCalculator {

    public CircleCalculation calculate(double radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double perimeter = 2 * Math.PI * radius;

        return new CircleCalculation(area, perimeter);
    }

}
