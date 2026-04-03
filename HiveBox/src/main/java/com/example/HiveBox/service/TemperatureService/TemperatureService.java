package com.example.HiveBox.service.TemperatureService;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TemperatureService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<String> senseBoxIds = List.of(
            "5eba5fbad46fb8001b799786",
            "5c21ff8f919bf8001adf2488",
            "5ade1acf223bd80019a1011c"
    );
    public String getTemperatureData() throws Exception {
        String cacheKey = "temperature_data";
        Instant now = Instant.now();
        Instant cutoff = now.minus(1, ChronoUnit.HOURS);

        List<Double> temps = new ArrayList<>();

        for (String boxId : senseBoxIds) {
            String url = "https://api.opensensemap.org/boxes/" + boxId;

            try {
                String response = restTemplate.getForObject(url, String.class);
                JsonNode root = objectMapper.readTree(response);

                JsonNode sensors = root.get("sensors");

                if (sensors != null) {
                    for (JsonNode sensor : sensors) {

                        String title = sensor.get("title").asText().toLowerCase();

                        if (title.contains("temp")) {
                            JsonNode lastMeasurement = sensor.get("lastMeasurement");

                            if (lastMeasurement != null) {
                                String timestamp = lastMeasurement.get("createdAt").asText();
                                String valueStr = lastMeasurement.get("value").asText();

                                Instant measuredTime = Instant.parse(timestamp);

                                if (measuredTime.isAfter(cutoff)) {
                                    temps.add(Double.parseDouble(valueStr));
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Error fetching data from box " + boxId + ": " + e.getMessage());
            }
        }

        if (temps.isEmpty()) {
            return "{\"error\": \"No recent temperature data available.\"}";
        }

        double avg = temps.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        String status;
        if (avg < 10) {
            status = "Too Cold";
        } else if (avg <= 36) {
            status = "Good";
        } else {
            status = "Too Hot";
        }

        Map<String, Object> result = new HashMap<>();
        result.put("average_temperature", Math.round(avg * 100.0) / 100.0);
        result.put("unit", "°C");
        result.put("status", status);
        result.put("sources", temps.size());

        String jsonResult = objectMapper.writeValueAsString(result);
        return jsonResult;
    }


}
