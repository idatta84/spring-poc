package com.springconcepts.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.springconcepts.constraints.PhoneNoConstraint;

@JsonInclude(Include.NON_NULL)
public class Customer {

    @Id
    private String id;

    @Size(min=3)
    private String firstName;
    private String lastName;
    
    //@Size(min=9, max=11)
    //@NotNull
    //@PhoneNoConstraint  //This is example of custom annotation for validation
    @Pattern(regexp="[0-9]{9,10}|[0-9]{3}-[0-9]{3}-[0-9]{4}")
    private String phoneNo;
    
	public Customer() {
		super();
		this.firstName = "aaa";
		this.lastName = "a";
		this.phoneNo = "000-000-0000";
	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = "000-000-0000";
	}
	
	public Customer(String firstName, String lastName, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}
	
	public Customer(String id, String firstName, String lastName, String phoneNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}

