package org.mge.designpatterns.decorator.decorators;

import org.mge.designpatterns.decorator.components.Beverage;

public class Whip implements CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double getCost() {
		return 2 + beverage.getCost();
	}
}
