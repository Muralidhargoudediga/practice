package org.mge.designpatterns.decorator.components;

public class Decaf implements Beverage {

	@Override
	public String getDescription() {
		return "Decaf";
	}

	@Override
	public double getCost() {
		return 20.40;
	}

}
