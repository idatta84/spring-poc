package com.springconcepts.designpatterns.factory;

public class PizzaPepperoni extends Pizza {
	@Override
	public void addIngredients() {
		System.out.println("Preparing ingredients for pepperoni pizza.");
	}

}