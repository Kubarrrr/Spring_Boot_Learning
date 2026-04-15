package com.nauka.CircleWstrzykiwanieZaleznosciHomework;

import org.springframework.stereotype.Service;

@Service
public class CircleService {
    private final CircleCalculator circleCalculator;

    public CircleService(CircleCalculator circleCalculator) {
        this.circleCalculator = circleCalculator;
    }

    public CircleResponse calculate(Double radius) {
        CircleCalculation circleCalculation = circleCalculator.calculate(radius);

        return CircleResponse.from(circleCalculation);
    }


}
