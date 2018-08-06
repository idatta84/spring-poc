package com.springconcepts.designpatterns.observer;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

public class Bidder2 implements Observer{
	Product2 observable;
    String bidderName;
    public Bidder2(String bidderName) {
        this.bidderName = bidderName;
    }
 
    @Override
    public String toString(){
        return bidderName;
    }

	@Override
	public void update(Observable o, Object arg) {
		this.observable = (Product2)o;
		String name = this.observable.getObserver().toString();
		if(name.equals(bidderName))
        {
            System.out.println("Hello "+bidderName+"! New bid of amount "+this.observable.getBidAmount()+" has been placed on "+this.observable.getProductName()+" by you");
        }
        if (!name.equals(bidderName))
            System.out.println("Hello "+bidderName+"! New bid of amount "+this.observable.getBidAmount()+" has been placed on "+this.observable.getProductName()+" by "+this.observable.getObserver());
    
	}
}