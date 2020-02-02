package org.mge.designpatterns.strategy;

public class Queen extends Character{
	public Queen() {
		weapon = new BowAndArrowBehavior();
	}
}
