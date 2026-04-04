package com.example.HiveBox.controller;

import com.example.HiveBox.service.TemperatureService.TemperatureService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class APIControllerTest {

    @Test
    void testGetVersion() {
        TemperatureService service = mock(TemperatureService.class);
        APIController controller = new APIController(service);
        String version = controller.getVersion();
        assertTrue(version.contains("v0.0.1"));
    }
    @Test
    void testTemperatureSuccess() throws Exception {
        TemperatureService service = mock(TemperatureService.class);

        when(service.getTemperatureData())
                .thenReturn("{\"average_temperature\":25}");

        APIController controller = new APIController(service);

        ResponseEntity<String> response = controller.getTemperature();

        assertEquals(200, response.getStatusCode().value());
    }

}
