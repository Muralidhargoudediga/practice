package org.mge.designpatterns.strategy;

public class SwordBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Sword");
	}

}
