package de.ch4inl3ss.model;

import java.util.List;

public class DataContainer {

	private String inputComplex;

	private List<String> outputComplex;

	private String temperature;

	private String humidity;

	private String windspeed;

	private String apiKey;

	private String latitude;

	private String longitude;

	public String getApiKey() {
		return apiKey;
	}

	public String getHumidity() {
		return humidity;
	}

	public String getInputComplex() {
		return inputComplex;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public List<String> getOutputComplex() {
		return outputComplex;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getWindspeed() {
		return windspeed;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public void setInputComplex(String inputComplex) {
		this.inputComplex = inputComplex;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setOutputComplex(List<String> outputComplex) {
		this.outputComplex = outputComplex;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}
}
