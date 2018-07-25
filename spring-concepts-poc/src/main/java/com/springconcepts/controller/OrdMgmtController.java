package com.springconcepts.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springconcepts.beans.ErrorResponse;
import com.springconcepts.beans.Order;
import com.springconcepts.beans.OrderDetailResponse;
import com.springconcepts.beans.OrderEntryResponse;
import com.springconcepts.bo.OrdMgmtBO;
import com.springconcepts.constants.GeneralConstants;

@RestController
public class OrdMgmtController {

	@Autowired
	private OrdMgmtBO ordMgmtBO;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Service to add order
	 * @param order
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/orders", consumes = GeneralConstants.CONTENT_TYPE_APPLICATION_JSON, produces = GeneralConstants.CONTENT_TYPE_APPLICATION_JSON)
	public OrderEntryResponse addOrder(@RequestBody @Valid Order order) {

		ErrorResponse errResponse = ordMgmtBO.addOrder(order);

		OrderEntryResponse orderEntryResponse = new OrderEntryResponse();
		// On error, respond back with generic error message else return tracking number
		if (Optional.ofNullable(errResponse).isPresent() && Optional.ofNullable(errResponse.getErrorCode()).isPresent()
				&& Optional.ofNullable(errResponse.getErrorDesc()).isPresent()) {
			orderEntryResponse.setErrorDetails(errResponse.getErrorCode(), errResponse.getErrorDesc());
			logger.info("Some exception ocurred while submitting the order");
		} else {
			orderEntryResponse.setTrackingId(order.getTrackingId());
			orderEntryResponse.setOrderStatus(order.getStatus());
			String logString = (new StringBuilder()).append("Order submitted successfully. TrackingId=").append(orderEntryResponse.getTrackingId()).toString();
			logger.info(logString);
		}
		return orderEntryResponse;
	}
	
	/**
	 * Service to fetch all order details. 
	 * @param trackingId
	 * @param display
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/orders", produces = GeneralConstants.CONTENT_TYPE_APPLICATION_JSON)
	public List<OrderDetailResponse> getAllOrderDetails(@RequestParam(value = "display", defaultValue="all") String display) {

		List<OrderDetailResponse> orderDetailResponseList = ordMgmtBO.getAllOrderDetails();

		/*if(display.equalsIgnoreCase("status")){
			Order order = new Order();
			order.setTrackingId(trackingId);
			order.setStatus(orderDetailResponse.getOrder().getStatus());
			orderDetailResponse.setOrder(order);
			logger.info("Returning only order status");
		}*/
		return orderDetailResponseList;
	}
	
	/**
	 * Service to update order
	 * @param order
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/orders/{trackingId}", consumes = GeneralConstants.CONTENT_TYPE_APPLICATION_JSON, produces = GeneralConstants.CONTENT_TYPE_APPLICATION_JSON)
	public OrderEntryResponse updateOrder(@PathVariable String trackingId, @RequestBody Order order) {

		order.setTrackingId(trackingId);
		
		ErrorResponse errResponse = ordMgmtBO.updateOrder(order);

		OrderEntryResponse orderEntryResponse = new OrderEntryResponse();
		// On error, respond back with generic error message else return tracking number
		if (Optional.ofNullable(errResponse).isPresent() && Optional.ofNullable(errResponse.getErrorCode()).isPresent()
				&& Optional.ofNullable(errResponse.getErrorDesc()).isPresent()) {
			orderEntryResponse.setErrorDetails(errResponse.getErrorCode(), errResponse.getErrorDesc());
			logger.info("Some exception ocurred while updating the order");
		} else {
			orderEntryResponse.setTrackingId(order.getTrackingId());
			orderEntryResponse.setOrderStatus(order.getStatus());
			String logString = (new StringBuilder()).append("Order updated successfully. TrackingId=").append(orderEntryResponse.getTrackingId()).toString();
			logger.info(logString);
		}
		return orderEntryResponse;
	}
	
	/**
	 * Service to fetch order details by trackingId. It will only return status if a path variable called display is passed with value "status".
	 * @param trackingId
	 * @param display
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/orders/{trackingId}", produces = GeneralConstants.CONTENT_TYPE_APPLICATION_JSON)
	public OrderDetailResponse getOrderDetails(@PathVariable String trackingId, @RequestParam(value = "display", defaultValue="all") String display) {

		OrderDetailResponse orderDetailResponse = ordMgmtBO.getOrderDetails(trackingId);

		if(display.equalsIgnoreCase("status")){
			Order order = new Order();
			order.setTrackingId(trackingId);
			order.setStatus(orderDetailResponse.getOrder().getStatus());
			orderDetailResponse.setOrder(order);
			logger.info("Returning only order status");
		}
		return orderDetailResponse;
	}

	/**
	 * Service to delete order. Only updates the status to deleted
	 * @param trackingId
	 * @param display
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "/orders/{trackingId}", produces = GeneralConstants.CONTENT_TYPE_APPLICATION_JSON)
	public OrderDetailResponse deleteOrder(@PathVariable String trackingId) {

		return ordMgmtBO.deleteOrder(trackingId);
	}

}
