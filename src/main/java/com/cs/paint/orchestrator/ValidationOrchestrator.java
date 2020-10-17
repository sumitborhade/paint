package com.cs.paint.orchestrator;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ValidationFactory;
import com.cs.paint.validator.service.Validator;

public class ValidationOrchestrator {

	public boolean performValidation(String inputString) {
		if (inputString == null) {
			throw new CustomException(ApplicationWarningCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		Validator validation = ValidationFactory.getValidationEntity(inputArray[0]);
		
		if(validation == null) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_DESIGN_TYPE);
		}
		
		return validation.validate(inputArray);
	}
	
	
}
