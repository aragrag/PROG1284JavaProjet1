package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import	com.amazonaws.services.iot.client.AWSIotException;
import	com.example.dto.WeatherPayload;
import	com.example.model.WeatherData;
import 	com.fasterxml.jackson.core.JsonProcessingException;
import  com.example.repository.WeatherDataRepository;

@RestController
public class HTTPController {

		@Autowired
		private WeatherDataRepository weatherDataRepository;
		
		@PostMapping("/send")
		public String sendData(@RequestBody WeatherPayload payload) throws AWSIotException, JsonProcessingException {
			// Créer un objet WeatherData à partir de WeatherPayload
			WeatherData weatherData = new WeatherData(payload.getTemperature(), payload.getHumidity(), LocalDateTime.now());
		
			// Enregistrer les données dans la base de données
			weatherDataRepository.save(weatherData);
		
			return "Message Published and Data Saved Successfully";
		}
		@GetMapping("/test")
		public String sendTest(@RequestBody WeatherPayload payload) throws AWSIotException, JsonProcessingException {
		
			return "Test !";
		}        
		
}
