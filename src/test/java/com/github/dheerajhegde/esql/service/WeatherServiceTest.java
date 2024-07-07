package com.github.dheerajhegde.esql.service;

import com.github.dheerajhegde.esql.dto.WeatherResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {

    @Test
    public void testGetWeatherInfo() {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        WeatherService weatherService = new WeatherService();
        WeatherService spyWeatherService = Mockito.spy(weatherService);

        WeatherResponse.CurrentWeather currentWeather = new WeatherResponse.CurrentWeather();
        currentWeather.setTemperature("20");
        currentWeather.setWeathercode("100");

        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setCurrentWeather(currentWeather);

        when(spyWeatherService.getWeatherInfo()).thenReturn("Temperature: 20°C, Weather Code: 100");

        String weatherInfo = spyWeatherService.getWeatherInfo();
        assertEquals("Temperature: 20°C, Weather Code: 100", weatherInfo);
    }
}
