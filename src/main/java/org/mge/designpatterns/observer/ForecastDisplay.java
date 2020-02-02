package org.mge.designpatterns.observer;

public class ForecastDisplay implements Observer, Displayable {
	private static int RAIN_INDICATIVE_PRESSURE = 27;
	private static String NO_RAIN = "No rain. Clear with periodic clouds";
	private static String CHANCE_OF_RAIN = "Chance of rain today";

	private int pressure;
	private Subject subject;

	public ForecastDisplay(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Forecast Display");
		System.out.println("-----------------");
		System.out.println(getForecast());
	}

	private String getForecast() {
		if (pressure <= RAIN_INDICATIVE_PRESSURE) {
			return CHANCE_OF_RAIN;
		}

		return NO_RAIN;
	}

	@Override
	public void update(WeatherDataBean weatherDataBean) {
		this.pressure = weatherDataBean.getPressure();
		display();
	}

}
