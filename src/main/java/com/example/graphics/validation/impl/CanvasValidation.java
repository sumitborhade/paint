package com.example.graphics.validation.impl;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.impl.CanvasCreationService;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validation.Validation;

public class CanvasValidation implements Validation {

	@Override
	public boolean validate(String[] inputArray) {

		if(CanvasCreationService.getCanvas() != null) {
			throw new CustomException(ApplicationStatusCode.CANVAS_ALREADY_PRESENT);
		}
		
		if(inputArray.length != 3) {
			throw new CustomException(ApplicationStatusCode.INCORRECT_CANVAS_INPUT_PARAMS);
		}
		
		if(!GenericUtils.isInteger(inputArray[1], inputArray[2]) ) {
			throw new CustomException(ApplicationStatusCode.CANVAS_INPUT_SHOULD_BE_INTEGER);
		}
		return true;
	}
}
