package com.springconcepts.designpatterns.abstractfactory;

public class ToppingFactorySicillian implements ToppingFactory {
	@Override
	public Cheese createCheese() {
		return new CheeseMozzarella();
	}

	@Override
	public Sauce createSauce() {
		return new SauceTomato();
	}
}
