package de.ch4inl3ss.model;

import java.util.List;

import de.ch4inl3ss.entity.Programmer;

public class DataContainer {

	private String inputComplex;

	private List<String> outputComplex;

	private String temperature;

	private String humidity;

	private String windspeed;

	private String apiKey;

	private String latitude;

	private String longitude;

	private Programmer programmer;

	private List<Programmer> programmers;

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

	public Programmer getProgrammer() {
		return programmer;
	}

	public List<Programmer> getProgrammers() {
		return programmers;
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

	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}

	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}
}
