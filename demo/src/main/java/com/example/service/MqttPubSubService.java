package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.iot.client.AWSIotException;
import com.example.util.MQTTConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import  com.example.dto.WeatherPayload;

@Service
public class MqttPubSubService {

    @Autowired
    MQTTConfig mqttConfig;
    
    public void publishMessage(WeatherPayload payload) throws AWSIotException, JsonProcessingException{

        mqttConfig.connectToIot(payload);
        mqttConfig.pub(payload);

    }
 
}
