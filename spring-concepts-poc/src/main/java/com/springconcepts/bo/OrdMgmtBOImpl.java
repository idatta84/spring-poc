package com.springconcepts.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springconcepts.beans.ErrorResponse;
import com.springconcepts.beans.Order;
import com.springconcepts.beans.OrderDetailResponse;
import com.springconcepts.constants.GeneralConstants;
import com.springconcepts.repository.OrderRepository;

@Component
public class OrdMgmtBOImpl implements OrdMgmtBO {

	@Autowired
	private OrderRepository orderRepository;

	// @Autowired
	// private OrderEntryQueue orderEntryQueue;

	@Autowired
	private ObjectMapper objectMapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Add the order
	 * 
	 * @param order
	 * @return
	 */
	public ErrorResponse addOrder(Order order) {
		ErrorResponse response = null;

		// Generate unique tracking number for the order
		order.setTrackingId(UUID.randomUUID().toString());
		// Set initial order status
		order.setStatus(GeneralConstants.ORDER_STATUS_SUBMITTED);

		// try {
		// Add order to Queue
		// orderEntryQueue.pushToQueue(objectMapper.writeValueAsString(order));
		// logger.info("Order pushed to queue");

		// Add order to database
		orderRepository.insert(order);
		logger.info("Order added to database");

		/*
		 * } catch (JsonProcessingException e) {
		 * logger.info("Error ocurred in json processing", e); response = new
		 * ErrorResponse();
		 * response.setErrorCode(GeneralConstants.RESPONSE_CODE_GENERIC_ERROR);
		 * response.setErrorDesc(GeneralConstants.RESPONSE_DESC_GENERIC_ERROR);
		 * }
		 */
		return response;
	}

	/**
	 * Update the order
	 * 
	 * @param order
	 * @return
	 */
	public ErrorResponse updateOrder(Order order) {
		ErrorResponse response = null;

		/*
		 * try { // Add order to Queue
		 * //orderEntryQueue.pushToQueue(objectMapper.writeValueAsString(order))
		 * ; //logger.info("Order pushed to queue");
		 * 
		 * } catch (JsonProcessingException e) {
		 * logger.info("Error ocurred in json processing", e); response = new
		 * ErrorResponse();
		 * response.setErrorCode(GeneralConstants.RESPONSE_CODE_GENERIC_ERROR);
		 * response.setErrorDesc(GeneralConstants.RESPONSE_DESC_GENERIC_ERROR);
		 * }
		 */
		return response;
	}

	/**
	 * Get the order details by trackingId
	 * 
	 * @param trackingId
	 * @return
	 */
	public OrderDetailResponse getOrderDetails(String trackingId) {
		OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
		String logString = (new StringBuilder()).append("Retrieving order details with trackingId=").append(trackingId)
				.toString();
		logger.info(logString);

		orderDetailResponse.setOrder(orderRepository.findByTrackingId(trackingId));

		logger.info(
				Optional.ofNullable(orderDetailResponse.getOrder()).isPresent() ? "Order found" : "Order not found");

		// On error, respond back with order not found error message
		if (!Optional.ofNullable(orderDetailResponse.getOrder()).isPresent()) {
			orderDetailResponse.setErrorCode(GeneralConstants.RESPONSE_CODE_ORDER_NOT_FOUND);
			orderDetailResponse.setErrorDesc(GeneralConstants.RESPONSE_DESC_ORDER_NOT_FOUND);
		}
		return orderDetailResponse;
	}

	/**
	 * Get all the order details
	 * 
	 * @param trackingId
	 * @return
	 */
	public List<OrderDetailResponse> getAllOrderDetails() {
		List<OrderDetailResponse> orderDetailResponseList = new ArrayList<>();
		logger.info("Retrieving order details");

		List<Order> orderList = orderRepository.findAll();

		if (Optional.ofNullable(orderList).isPresent() && !orderList.isEmpty()) {
			for (Order order : orderList) {
				OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
				orderDetailResponse.setOrder(order);
				orderDetailResponseList.add(orderDetailResponse);
			}

		}

		logger.info(
				Optional.ofNullable(orderDetailResponseList.get(0)).isPresent() ? "Orders found" : "Orders not found");

		// On error, respond back with order not found error message
		if (!Optional.ofNullable(orderDetailResponseList.get(0)).isPresent()) {
			OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
			orderDetailResponse.setErrorCode(GeneralConstants.RESPONSE_CODE_ORDER_NOT_FOUND);
			orderDetailResponse.setErrorDesc(GeneralConstants.RESPONSE_DESC_ORDER_NOT_FOUND);
			orderDetailResponseList.add(orderDetailResponse);

		}
		return orderDetailResponseList;
	}

	/**
	 * Delete the order
	 * 
	 * @param trackingId
	 * @return
	 */
	public OrderDetailResponse deleteOrder(String trackingId) {
		OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
		String logString = (new StringBuilder()).append("Retrieving order details with trackingId=").append(trackingId)
				.toString();
		logger.info(logString);

		Order order = orderRepository.findByTrackingId(trackingId);
		order.setStatus(GeneralConstants.ORDER_STATUS_DELETED);
		orderRepository.save(order);

		orderDetailResponse.setOrder(order);

		logger.info(Optional.ofNullable(order).isPresent() ? "Order found" : "Order not found");

		// On error, respond back with order not found error message
		if (!Optional.ofNullable(order).isPresent()) {
			orderDetailResponse.setErrorCode(GeneralConstants.RESPONSE_CODE_ORDER_NOT_FOUND);
			orderDetailResponse.setErrorDesc(GeneralConstants.RESPONSE_DESC_ORDER_NOT_FOUND);
		}
		return orderDetailResponse;
	}

}
