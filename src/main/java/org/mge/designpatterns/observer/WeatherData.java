package org.mge.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

	private List<Observer> observers;
	private WeatherDataBean weatherDataBean;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);

		if (index >= 0) {
			observers.remove(index);
		}
	}

	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(weatherDataBean);
		}
	}

	public WeatherDataBean getWeatherDataBean() {
		return weatherDataBean;
	}

	public void setWeatherDataBean(WeatherDataBean weatherDataBean) {
		this.weatherDataBean = weatherDataBean;
		notifyObservers();
	}
}
