package org.mge.designpatterns.strategy;

public class DriverProgram {
	public static void main(String[] args) {
		Character king = new King();
		king.fight();
		king.setWeapon(new MaceBehavior());
		king.fight();
		
		Character queen = new Queen();
		queen.fight();
	}
}
