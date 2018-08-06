package com.springconcepts.designpatterns.abstractfactory;

public class SauceCaliforniaOil implements Sauce {

	public SauceCaliforniaOil(){
        prepareSauce();
    }

	@Override
	public void prepareSauce() {
		System.out.println("Preparing california oil sauce..");
	}

}
