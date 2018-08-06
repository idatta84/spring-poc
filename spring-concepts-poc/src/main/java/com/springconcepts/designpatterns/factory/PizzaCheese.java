package com.springconcepts.designpatterns.factory;

public class PizzaCheese extends Pizza {

	@Override
	public void addIngredients() {
		System.out.println("Preparing ingredients for cheese pizza.");
	}

}