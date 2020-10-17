package com.example.graphics.validator.service.impl;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validator.service.Validator;

public class CanvasValidation implements Validator {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfCanvasIsAlreadyPresent();
		validateIfCanvasHasCorrectNumberOfInputParams(inputArray);
		validateIfTheCanvasInputPointIsInteger(inputArray);
		return true;
	}
	
	private void validateIfCanvasIsAlreadyPresent() {
		if(CanvasCreationService.getCanvas() != null) {
			throw new CustomException(ApplicationWarningCode.CANVAS_ALREADY_PRESENT);
		}
	}

	private void validateIfCanvasHasCorrectNumberOfInputParams(String[] inputArray) {
		if(inputArray.length != 3) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_CANVAS_INPUT_PARAMS);
		}
	}
	
	private void validateIfTheCanvasInputPointIsInteger(String[] inputArray) {
		if(!GenericUtils.isInteger(inputArray[1], inputArray[2]) ) {
			throw new CustomException(ApplicationWarningCode.CANVAS_INPUT_SHOULD_BE_INTEGER);
		}
	}
}
