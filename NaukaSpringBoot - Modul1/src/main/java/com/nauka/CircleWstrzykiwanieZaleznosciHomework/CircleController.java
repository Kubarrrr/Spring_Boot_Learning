package com.nauka.CircleWstrzykiwanieZaleznosciHomework;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/circle")
public class CircleController {

    CircleService circleService;

    public CircleController(CircleService circleService) {
        this.circleService = circleService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CircleResponse> calc(@RequestBody CircleCalculateRequest request) {
        return ResponseEntity.ok(
                circleService.calculate(request.getRadius())
        );
    }

}
