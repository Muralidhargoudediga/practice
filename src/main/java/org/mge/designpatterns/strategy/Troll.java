package org.mge.designpatterns.strategy;

public class Troll extends Character {
	public Troll(){
		weapon = new AxeBehavior();
	}
}
