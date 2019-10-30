package org.mge.designpatterns.decorator.components;

public class DarkRoast implements Beverage {
	
	@Override
	public String getDescription() {
		return "Dark Roast";
	}

	@Override
	public double getCost() {
		return 15.20;
	}

}
