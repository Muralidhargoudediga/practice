package org.mge.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer, Displayable {
	private List<Integer> temperatures;
	private double averageTemperature;
	private int minTemperature;
	private int maxTemperature;
	private Subject subject;

	public StatisticsDisplay(Subject subject) {
		temperatures = new ArrayList<>();
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Statistics Display");
		System.out.println("--------------------");
		System.out.println("Avg Temperature : " + averageTemperature);
		System.out.println("Max Temperature : " + maxTemperature);
		System.out.println("Min Temperature : " + minTemperature);
	}

	@Override
	public void update(WeatherDataBean weatherDataBean) {
		updateAverageTemperature(weatherDataBean.getTemperature());
		updateMaxTemperatue(weatherDataBean.getTemperature());
		updateMinTemperatue(weatherDataBean.getTemperature());
		display();
	}

	private void updateAverageTemperature(int temp) {
		double totalTemp = averageTemperature * temperatures.size();
		temperatures.add(temp);
		totalTemp += temp;
		averageTemperature = totalTemp / temperatures.size();
	}

	private void updateMinTemperatue(int temp) {
		if (minTemperature == 0) {
			minTemperature = temp;
		} else if (minTemperature > temp) {
			minTemperature = temp;
		}
	}

	private void updateMaxTemperatue(int temp) {
		if (maxTemperature < temp) {
			maxTemperature = temp;
		}
	}

}
