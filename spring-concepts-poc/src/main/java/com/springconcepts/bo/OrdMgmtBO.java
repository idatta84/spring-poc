package com.springconcepts.bo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springconcepts.beans.ErrorResponse;
import com.springconcepts.beans.Order;
import com.springconcepts.beans.OrderDetailResponse;

@Component
public interface OrdMgmtBO {

	/**
	 * Add the order
	 * 
	 * @param order
	 * @return
	 */
	public ErrorResponse addOrder(Order order);
	
	/**
	 * Update the order
	 * 
	 * @param order
	 * @return
	 */
	public ErrorResponse updateOrder(Order order);
	
	/**
	 * Get the order details
	 * @param trackingId
	 * @return
	 */
	public OrderDetailResponse getOrderDetails(String trackingId);
	
	/**
	 * Get all the order details
	 * @param trackingId
	 * @return
	 */
	public List<OrderDetailResponse> getAllOrderDetails();
	
	/**
	 * Delete the order
	 * @param trackingId
	 * @return
	 */
	public OrderDetailResponse deleteOrder(String trackingId);
	
}
