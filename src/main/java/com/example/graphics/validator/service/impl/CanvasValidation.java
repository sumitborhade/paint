package com.example.graphics.validator.service.impl;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.creator.service.Validator;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.utils.GenericUtils;

public class CanvasValidation implements Validator {

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
