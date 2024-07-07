package com.github.dheerajhegde.esql.controller;

import com.github.dheerajhegde.esql.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    public void testGetWeather() throws Exception {
        when(weatherService.getWeatherInfo()).thenReturn("Temperature: 20°C, Weather Code: 100");

        mockMvc.perform(get("/getWeather"))
                .andExpect(status().isOk())
                .andExpect(content().string("Temperature: 20°C, Weather Code: 100"));
    }
}
