package com.springconcepts.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springconcepts.constraints.PhoneNoConstraint;

public class PhoneNoValidator implements
ConstraintValidator<PhoneNoConstraint, String> {

  @Override
  public void initialize(PhoneNoConstraint phoneNoField) {
	  //do nothing
  }

  @Override
  public boolean isValid(String phoneNoField,
    ConstraintValidatorContext cxt) {
      return phoneNoField != null && phoneNoField.matches("[0-9]{9,10}|[0-9]{3}-[0-9]{3}-[0-9]{4}")
        && (phoneNoField.length() > 8) && (phoneNoField.length() < 14);
  }

  /*public static void main(String[] args) {
	System.out.println("111-222-3333".matches("[0-9]{3}-[0-9]{3}-[0-9]{4}"));
	System.out.println("1112223333".matches("[0-9]{3}-[0-9]{3}-[0-9]{4}"));
	System.out.println("1112223333".matches("[0-9]{9,10}"));
	System.out.println("1112223333".matches("[0-9]{9,10}|[0-9]{3}-[0-9]{3}-[0-9]{4}"));
  }*/
}