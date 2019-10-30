package org.mge.designpatterns.decorator.components;

public class HouseBlend implements Beverage {
	String desc;
	public HouseBlend() {
		desc = "House Blend";
	}
	@Override
	public String getDescription() {
		return desc;
	}

	@Override
	public double getCost() {
		return 10.50;
	}

}
