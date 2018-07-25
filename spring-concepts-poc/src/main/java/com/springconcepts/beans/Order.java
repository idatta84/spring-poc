package com.springconcepts.beans;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Order {

	@Id
	private String id;
	private String summary;
	@Valid
	private Customer customer;
	private Integer quantity;
	private float price;
	private String trackingId;
	private String status;
	
	public Order(String summary, Customer customer, Integer quantity, float price, String trackingId,
			String status) {
		super();
		this.summary = summary;
		this.customer = customer;
		this.quantity = quantity;
		this.price = price;
		this.trackingId = trackingId;
		this.status = status;
	}
	
	public Order(String id, String summary, Customer customer, Integer quantity, float price, String trackingId,
			String status) {
		super();
		this.id = id;
		this.summary = summary;
		this.customer = customer;
		this.quantity = quantity;
		this.price = price;
		this.trackingId = trackingId;
		this.status = status;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", summary=" + summary + ", customer=" + customer + ", quantity=" + quantity
				+ ", price=" + price + ", trackingId=" + trackingId + ", status=" + status + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}