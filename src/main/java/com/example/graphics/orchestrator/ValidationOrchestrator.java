package com.example.graphics.orchestrator;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.creator.service.Validator;
import com.example.graphics.exception.CustomException;
import com.example.graphics.factory.ValidationFactory;

public class ValidationOrchestrator {

	public boolean performValidation(String inputString) {
		if (inputString == null) {
			throw new CustomException(ApplicationStatusCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		Validator validation = ValidationFactory.getValidationEntity(inputArray[0]);
		
		if(validation == null) {
			throw new CustomException(ApplicationStatusCode.INCORRECT_DESIGN_TYPE);
		}
		
		validation.validate(inputArray);
		
		return true;
	}
	
	
}
