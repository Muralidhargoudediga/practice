package org.mge.designpatterns.decorator.decorators;

import org.mge.designpatterns.decorator.components.Beverage;

public class Soy implements CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double getCost() {
		return 3 + beverage.getCost();
	}
}
