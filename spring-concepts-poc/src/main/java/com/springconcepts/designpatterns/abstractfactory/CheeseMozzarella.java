package com.springconcepts.designpatterns.abstractfactory;

public class CheeseMozzarella implements Cheese {
	public CheeseMozzarella() {
		prepareCheese();
	}

	@Override
	public void prepareCheese() {
		System.out.println("Preparing mozzarella cheese...");
	}
}
