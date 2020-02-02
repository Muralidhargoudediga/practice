package org.mge.designpatterns.observer;

public class WeatherDataBean {
	private int temperature;
	private int humidity;
	private int pressure;

	public WeatherDataBean(int temperature, int humidity, int pressure) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
}
