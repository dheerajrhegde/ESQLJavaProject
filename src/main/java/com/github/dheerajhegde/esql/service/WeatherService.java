package com.github.dheerajhegde.esql.service;

import com.github.dheerajhegde.esql.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=51.5074&longitude=-0.1278&current_weather=true";

    public String getWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(apiUrl, WeatherResponse.class);
        if (response != null && response.getCurrentWeather() != null) {
            return String.format("Temperature: %s°C, Weather Code: %s",
                    response.getCurrentWeather().getTemperature(),
                    response.getCurrentWeather().getWeathercode());
        } else {
            throw new RuntimeException("Failed to retrieve weather information");
        }
    }
}
