package org.mge.designpatterns.decorator;

import org.mge.designpatterns.decorator.components.Beverage;
import org.mge.designpatterns.decorator.components.DarkRoast;
import org.mge.designpatterns.decorator.components.Espresso;
import org.mge.designpatterns.decorator.components.HouseBlend;
import org.mge.designpatterns.decorator.decorators.Mocha;
import org.mge.designpatterns.decorator.decorators.Soy;
import org.mge.designpatterns.decorator.decorators.Whip;

public class CoffeeDayCoffee {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();

		System.out.println(beverage.getDescription() + " : Rs."
				+ beverage.getCost());

		beverage = new DarkRoast();
		beverage = new Mocha(beverage);
		beverage = new Mocha(beverage);
		beverage = new Whip(beverage);

		System.out.println(beverage.getDescription() + " : Rs."
				+ beverage.getCost());

		beverage = new HouseBlend();
		beverage = new Soy(beverage);
		beverage = new Mocha(beverage);
		beverage = new Whip(beverage);

		System.out.println(beverage.getDescription() + " : Rs."
				+ beverage.getCost());
	}

}
