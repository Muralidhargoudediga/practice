package org.mge.designpatterns.observer;

public class DriverProgram {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
				weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setWeatherDataBean(new WeatherDataBean(78, 65, 35));
		weatherData.setWeatherDataBean(new WeatherDataBean(82, 63, 26));
		weatherData.setWeatherDataBean(new WeatherDataBean(90, 59, 23));
	}
}
