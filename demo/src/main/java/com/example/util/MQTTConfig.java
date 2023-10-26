package com.example.util;

import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.iot.client.AWSIotDevice;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.example.dto.MyMessage;
import com.example.dto.WeatherPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MQTTConfig {
    String clientEndpoint = "alg2xot8j7ilo-ats.iot.us-east-1.amazonaws.com";
    String clientId = "WeatherMonitor";  
    String  awsAccessKeyId = "AKIA2YPMQ6E3TXOFMIUV";
    String  awsSecretAccessKey = "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";
    
    AWSIotMqttClient  client = null;
 
    public void  connectToIot(WeatherPayload payload) throws AWSIotException, JsonProcessingException{


        client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, null);
        client.connect();   
        System.out.println("Connected to IoT"); 

        // MyMessage message = new MyMessage(topic, qos, mapper.writeValueAsString(payload)); 
        // client.publish( message, timeout);     
    }

    public void pub(WeatherPayload payload) throws AWSIotException, JsonProcessingException{
        String topic = "topic_weather";
        AWSIotQos qos = AWSIotQos.QOS0;
        long timeout = 5000; 
        ObjectMapper mapper = new ObjectMapper();
        AWSIotDevice device = new AWSIotDevice(clientId);
        client.attach(device);
        
        MyMessage message = new MyMessage(topic, qos, mapper.writeValueAsString(payload)); 
        client.publish( message, timeout);          
    }


}
