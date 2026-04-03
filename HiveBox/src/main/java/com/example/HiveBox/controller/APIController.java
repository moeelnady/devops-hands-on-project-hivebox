package com.example.HiveBox.controller;

import com.example.HiveBox.service.TemperatureService.TemperatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class APIController {
    private final TemperatureService temperatureService;

    public APIController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }
    @GetMapping("/version")
    public String getVersion(){
        return "My current Application Version is : v0.0.1";
    }
    @GetMapping("/temperature")
    public ResponseEntity<String> getTemperature() {
        try {
            String result = temperatureService.getTemperatureData();

            if (result.contains("error")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
            }

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Internal server error\"}");
        }
    }
}
