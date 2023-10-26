package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "weather_data")
public class WeatherData {

	private long id;
	private String temperature;
	private String humidity;
    private LocalDateTime timestamp;
	
	public WeatherData() {}
	
	public WeatherData(String temperature, String humidity, LocalDateTime tmp) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.timestamp = tmp;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "temperature", nullable = false)
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	@Column(name = "humidity", nullable = false)
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	@Column(name = "timestamp", nullable = false)
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", temperature=" + temperature + ", humidity=" + humidity + ", timestamp=" + timestamp
				+ "]";
	}
}