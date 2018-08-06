package com.springconcepts.designpatterns.abstractfactory;

public class ToppingFactoryGourmet implements ToppingFactory {
	@Override
	public Cheese createCheese() {
		return new CheeseGoat();
	}

	@Override
	public Sauce createSauce() {
		return new SauceCaliforniaOil();
	}
}
