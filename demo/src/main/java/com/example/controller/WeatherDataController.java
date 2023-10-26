package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import  com.example.repository.WeatherDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import	com.example.model.WeatherData;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherDataController {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @GetMapping("/weatherdata")
    public String getWeatherData(Model model) {
        List<WeatherData> weatherDataList = weatherDataRepository.findAll();
        Collections.reverse(weatherDataList);
        model.addAttribute("weatherDataList", weatherDataList);
        return "weatherdata";
    }
}
