package com.cs.paint.orchestrator;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeValidatorFactory;
import com.cs.paint.validator.service.Validator;

public class ShapeValidatorOrchestrator {

	public boolean performValidation(String inputString) {
		if (inputString == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		Validator validation = ShapeValidatorFactory.getValidationEntity(inputArray[0]);
		
		if(validation == null) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_DESIGN_TYPE);
		}
		
		return validation.validate(inputArray);
	}
	
	
}
