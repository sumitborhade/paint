package com.example.graphics.validation.impl;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.factory.ValidationFactory;
import com.example.graphics.validation.Validation;

public class ValidationOrchestrator {

	public boolean triggerValidation(String inputString) {
		
		if (inputString == null) {
			throw new CustomException(ExceptionCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		Validation validation = ValidationFactory.getValidationEntity(inputArray[0]);
		
		if(validation == null) {
			throw new CustomException(ExceptionCode.INCORRECT_DESIGN_TYPE);
		}
		
		validation.validate(inputArray);
		
		return true;
	}
	
	
}
