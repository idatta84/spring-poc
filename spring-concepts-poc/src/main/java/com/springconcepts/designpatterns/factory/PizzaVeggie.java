package com.springconcepts.designpatterns.factory;

public class PizzaVeggie extends Pizza {
	@Override
	public void addIngredients() {
		System.out.println("Preparing ingredients for veggie pizza.");
	}

}