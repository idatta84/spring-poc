package com.springconcepts.beans;

public class OrderDetailResponse extends ErrorResponse {

	private Order order;

	public OrderDetailResponse(Order order) {
		super();
		this.order = order;
	}

	public OrderDetailResponse() {
		super();
	}

	public OrderDetailResponse(String errorCode, String errorDesc) {
		super(errorCode, errorDesc);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderDetailResponse [order=" + order + " " + super.toString() + "]";
	}

}
