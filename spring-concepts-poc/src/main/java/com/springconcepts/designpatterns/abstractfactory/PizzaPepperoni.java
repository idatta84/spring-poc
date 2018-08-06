package com.springconcepts.designpatterns.abstractfactory;

public class PizzaPepperoni extends Pizza {
	ToppingFactory toppingFactory;

	public PizzaPepperoni(ToppingFactory toppingFactory) {

		this.toppingFactory = toppingFactory;
	}

	@Override
	public void addIngredients() {
		System.out.println("Preparing ingredients for pepperoni pizza.");
		toppingFactory.createCheese();
		toppingFactory.createSauce();
	}

}