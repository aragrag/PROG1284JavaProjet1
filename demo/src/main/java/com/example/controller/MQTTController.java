package com.example.controller;

import java.time.LocalDateTime;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.ui.Model;

import	com.amazonaws.services.iot.client.AWSIotException;
import	com.example.dto.WeatherPayload;
import	com.example.model.WeatherData;
import  com.example.service.MqttPubSubService;
import 	com.fasterxml.jackson.core.JsonProcessingException;
import  com.example.repository.WeatherDataRepository;

@RestController
public class MQTTController {
		@Autowired
		private MqttPubSubService service;

		@Autowired
		private WeatherDataRepository weatherDataRepository;
		
		@PostMapping("/publish")
		public String publishMessaged(@RequestBody WeatherPayload payload) throws AWSIotException, JsonProcessingException {
			// Publier le message MQTT
			service.publishMessage(payload);
		
			// Créer un objet WeatherData à partir de WeatherPayload
			WeatherData weatherData = new WeatherData(payload.getTemperature(), payload.getHumidity(), LocalDateTime.now());
		
			// Enregistrer les données dans la base de données
			weatherDataRepository.save(weatherData);
		
			return "Message Published and Data Saved Successfully";
		}
		
	}
