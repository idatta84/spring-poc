package com.springconcepts.designpatterns.abstractfactory;

public class SauceTomato implements Sauce {

	public SauceTomato(){
        prepareSauce();
    }

	@Override
	public void prepareSauce() {
		System.out.println("Preparing tomato sauce..");
	}

}
