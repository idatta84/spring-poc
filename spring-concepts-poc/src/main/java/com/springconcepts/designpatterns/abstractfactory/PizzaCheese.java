package com.springconcepts.designpatterns.abstractfactory;

public class PizzaCheese extends Pizza {
	ToppingFactory toppingFactory;

	public PizzaCheese(ToppingFactory toppingFactory) {

		this.toppingFactory = toppingFactory;
	}

	@Override
	public void addIngredients() {
		System.out.println("Preparing ingredients for cheese pizza.");
		toppingFactory.createCheese();
		toppingFactory.createSauce();
	}

}