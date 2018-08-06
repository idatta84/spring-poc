package com.springconcepts.designpatterns.factory;

public class PizzaFactoryImpl implements PizzaFactory {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza;
		switch (type.toLowerCase()) {
		case "cheese":
			pizza = new PizzaCheese();
			break;
		case "pepperoni":
			pizza = new PizzaPepperoni();
			break;
		case "veggie":
			pizza = new PizzaVeggie();
			break;
		default:
			throw new IllegalArgumentException("No such pizza.");
		}

		pizza.addIngredients();
		pizza.bakePizza();
		return pizza;
	}
}
