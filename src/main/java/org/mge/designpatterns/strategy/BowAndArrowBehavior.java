package org.mge.designpatterns.strategy;

public class BowAndArrowBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Bow And Arrow");
	}

}
