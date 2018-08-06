package com.springconcepts.designpatterns.abstractfactory;

public interface ToppingFactory {
    public abstract Cheese createCheese();
    public abstract Sauce createSauce();
}
