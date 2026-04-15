package com.nauka.WstrzykiwanieZaleznosci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bmi")
public class BmiCalculatorController {

    private BmiCalculatorService bmiCalculatorService;

    public BmiCalculatorController(BmiCalculatorService bmiCalculatorService) {
        this.bmiCalculatorService = bmiCalculatorService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<BmiCalculateResponse> calculateBmi(@RequestBody BmiCalculateRequest bmiCalculateRequest) {
        System.out.println("calculate bmi");

        BmiCalculateResponse response = bmiCalculatorService.calculateBmi(
                bmiCalculateRequest.getWeight(),
                bmiCalculateRequest.getHeight()
        );

        return ResponseEntity.ok(response);
    }

}
