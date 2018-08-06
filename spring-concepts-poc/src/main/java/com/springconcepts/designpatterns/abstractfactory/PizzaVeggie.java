package com.springconcepts.designpatterns.abstractfactory;

public class PizzaVeggie extends Pizza {
	ToppingFactory toppingFactory;

	public PizzaVeggie(ToppingFactory toppingFactory) {

		this.toppingFactory = toppingFactory;
	}

	@Override
	public void addIngredients() {
		System.out.println("Preparing ingredients for veggie pizza.");
		toppingFactory.createCheese();
		toppingFactory.createSauce();
	}

}