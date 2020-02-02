package org.mge.designpatterns.strategy;

public class King extends Character {
	public King() {
		weapon = new SwordBehavior();
	}
}
