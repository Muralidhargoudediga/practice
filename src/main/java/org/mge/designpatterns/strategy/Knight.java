package org.mge.designpatterns.strategy;

public class Knight extends Character {
	public Knight() {
		weapon = new KnifeBehavior();
	}
}
