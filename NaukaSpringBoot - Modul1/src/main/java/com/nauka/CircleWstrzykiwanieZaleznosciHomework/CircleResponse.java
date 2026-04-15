package com.nauka.CircleWstrzykiwanieZaleznosciHomework;

public record CircleResponse(Double area, Double perimeter) {

    public static CircleResponse from(CircleCalculation circleCalculation) {
        return new CircleResponse(
                circleCalculation.getArea(),
                circleCalculation.getPerimeter()
        );
    }
}
