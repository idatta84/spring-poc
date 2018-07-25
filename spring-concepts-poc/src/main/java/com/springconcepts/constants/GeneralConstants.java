package com.springconcepts.constants;

public class GeneralConstants {
	
	private GeneralConstants() {
		super();
	}
	
	// ORDER STATUSES
	public static final String ORDER_STATUS_SUBMITTED = "Submitted";
	public static final String ORDER_STATUS_PROCESSING = "Processing";
	public static final String ORDER_STATUS_READY_SHIPPING = "Ready for Shipping";
	public static final String ORDER_STATUS_SHIPPED = "Shipped";
	public static final String ORDER_STATUS_COMPLETED = "Completed";
	public static final String ORDER_STATUS_DELETED = "Deleted";
	
	public static final String QUEUE_LISTENER_RECEIVED_MESSAGE = "receivedMessage";
	
	public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
	
	// ERRORS
	public static final String RESPONSE_CODE_GENERIC_ERROR = "500";
	public static final String RESPONSE_DESC_GENERIC_ERROR = "Your order could not be processed at this point due to a server issue. Please try again later.";
	public static final String RESPONSE_CODE_ORDER_NOT_FOUND = "501";
	public static final String RESPONSE_DESC_ORDER_NOT_FOUND = "The order corresponding to the given tracking id could not be found.";
	
}
