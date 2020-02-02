package org.mge.designpatterns.strategy;

public class MaceBehavior implements WeaponBehavior {

	@Override
	public void useWeapon() {
		System.out.println("Mace");
	}
	
}
