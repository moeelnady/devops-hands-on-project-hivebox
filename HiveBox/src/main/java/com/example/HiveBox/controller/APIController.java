package com.example.HiveBox.controller;

import com.example.HiveBox.service.TemperatureService.TemperatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for API endpoints.
 */
@RestController
@RequestMapping("/v1")
public final class APIController {

    private final TemperatureService temperatureService;

    /**
     * Constructor.
     *
     * @param temperatureService service dependency
     */
    public APIController(final TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    /**
     * Returns API version.
     *
     * @return version string
     */
    @GetMapping("/version")
    public String getVersion() {
        return "My current Application Version is : v0.0.1";
    }

    /**
     * Returns average temperature.
     *
     * @return temperature response
     */
    @GetMapping("/temperature")
    public ResponseEntity<String> getTemperature() {
        try {
            String result = temperatureService.getTemperatureData();

            if (result.contains("error")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(result);
            }

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR
            ).body("{\"error\": \"Internal server error\"}");
        }
    }
}