package com.springconcepts.designpatterns.abstractfactory;

public class CheeseGoat implements Cheese {
	 
    public  CheeseGoat(){
       prepareCheese();
    }
    @Override
    public void prepareCheese(){
        System.out.println("Preparing goat cheese...");
    }
}
