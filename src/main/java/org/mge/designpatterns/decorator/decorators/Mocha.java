package org.mge.designpatterns.decorator.decorators;

import org.mge.designpatterns.decorator.components.Beverage;

public class Mocha implements CondimentDecorator {
	Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double getCost() {
		return 5 + beverage.getCost();
	}
}
