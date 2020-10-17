package com.cs.paint.service.validator.impl;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.ValidatorService;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.utils.GenericUtils;

/**
 * Single Responsibility purpose: 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class CanvasValidator implements ValidatorService {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfCanvasIsAlreadyPresent();
		validateIfCanvasHasCorrectNumberOfInputParams(inputArray);
		validateIfTheCanvasInputPointIsInteger(inputArray);
		return true;
	}
	
	private void validateIfCanvasIsAlreadyPresent() {
		if(CanvasService.getCanvas() != null) {
			throw new CustomException(ApplicationExceptionCode.CANVAS_ALREADY_PRESENT);
		}
	}

	private void validateIfCanvasHasCorrectNumberOfInputParams(String[] inputArray) {
		if(inputArray.length != 3) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_CANVAS_INPUT_PARAMS);
		}
	}
	
	private void validateIfTheCanvasInputPointIsInteger(String[] inputArray) {
		if(!GenericUtils.isInteger(inputArray[1], inputArray[2]) ) {
			throw new CustomException(ApplicationExceptionCode.CANVAS_INPUT_SHOULD_BE_INTEGER);
		}
	}
}
