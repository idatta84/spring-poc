package com.springconcepts.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderEntryResponse extends ErrorResponse {
	private String trackingId;
	private String orderStatus;

	@Autowired
	private ObjectMapper objectMapper;

	public OrderEntryResponse() {
		super();
	}

	public OrderEntryResponse(String trackingId, String orderStatus) {
		super();
		this.trackingId = trackingId;
		this.orderStatus = orderStatus;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		try {
			return objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
