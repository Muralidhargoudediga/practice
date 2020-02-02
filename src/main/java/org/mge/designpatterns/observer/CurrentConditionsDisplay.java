package org.mge.designpatterns.observer;

public class CurrentConditionsDisplay implements Observer, Displayable {
	private WeatherDataBean weatherDataBean;
	private Subject subject;

	public CurrentConditionsDisplay(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}

	@Override
	public void update(WeatherDataBean weatherDataBean) {
		this.weatherDataBean = weatherDataBean;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current Conditions Display: ");
		System.out.println("---------------------------");
		System.out.println("Temperature : " + weatherDataBean.getTemperature());
		System.out.println("Humidity : " + weatherDataBean.getHumidity());
		System.out.println("Pressure : " + weatherDataBean.getPressure());
	}
}
