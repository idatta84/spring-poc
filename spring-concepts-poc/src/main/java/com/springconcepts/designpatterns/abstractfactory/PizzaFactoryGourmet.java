package com.springconcepts.designpatterns.abstractfactory;

public class PizzaFactoryGourmet implements PizzaFactory {

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza;
		ToppingFactory toppingFactory = new ToppingFactoryGourmet();
		switch (type.toLowerCase()) {
		case "cheese":
			pizza = new PizzaCheese(toppingFactory);
			break;
		case "pepperoni":
			pizza = new PizzaPepperoni(toppingFactory);
			break;
		case "veggie":
			pizza = new PizzaVeggie(toppingFactory);
			break;
		default:
			throw new IllegalArgumentException("No such pizza.");
		}

		pizza.addIngredients();
		pizza.bakePizza();
		return pizza;
	}
}
