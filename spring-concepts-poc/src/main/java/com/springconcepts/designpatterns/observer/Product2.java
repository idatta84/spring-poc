package com.springconcepts.designpatterns.observer;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;
 
public class Product2 extends Observable{
    //private ArrayList<Observer> observers = new ArrayList<>();
    private String productName;
    private BigDecimal bidAmount;
    private Observer observer;
 
    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}

	public Observer getObserver() {
		return observer;
	}

	public void setObserver(Observer observer) {
		this.observer = observer;
	}

	public Product2(String productName, BigDecimal bidAmount){
        this.productName=productName;
        this.bidAmount=bidAmount;
    }
 
    public void setBidAmount(Observer observer,BigDecimal newBidAmount){
        if(bidAmount.compareTo(newBidAmount)<0){
            this.observer=observer;
            this.bidAmount=newBidAmount;
            notifyObservers();
        }
        else {
            System.out.println("New bid amount cannot be less or equal to current bid amount: "+this.bidAmount);
        }
    }
 
    /*@Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("-----------------"+observer+" has withdrawn from bidding----------------");
    }
 
    @Override
    public void notifyObservers() {
        System.out.println("-----------------New bid placed----------------");
        for (Observer ob : observers) {
            ob.update(this.observer,this.productName,this.bidAmount );
        }
    }*/
 
}
