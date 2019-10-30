package org.mge.designpatterns.decorator.decorators;

import org.mge.designpatterns.decorator.components.Beverage;

public class SteamedMilk implements CondimentDecorator {
	Beverage beverage;

	public SteamedMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Steamed Milk";
	}

	@Override
	public double getCost() {
		return 2 + beverage.getCost();
	}
}
