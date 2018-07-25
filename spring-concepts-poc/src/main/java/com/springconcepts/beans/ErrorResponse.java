package com.springconcepts.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private String errorCode;
	private String errorDesc;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String errorCode, String errorDesc) {
		super();
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public void setErrorDetails(String errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

}
