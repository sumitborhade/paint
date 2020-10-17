package com.cs.paint.service.validator.impl;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.ValidatorService;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.utils.GenericUtils;

/**
 * Single Responsibility purpose: To make change to this class if the any canvas validation needs to be changed or added.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class CanvasValidator implements ValidatorService {

	/***
	 * It accepts input and triggers various methods to perform validations.
	 */
	@Override
	public boolean validate(String[] inputArray) {
		validateIfCanvasIsAlreadyPresent();
		validateIfCanvasHasCorrectNumberOfInputParams(inputArray);
		validateIfTheCanvasInputPointIsInteger(inputArray);
		return true;
	}
	
	/**
	 * This method validates if the canvas is already present and throws exception if any already existing.
	 * @param inputArray
	 */
	private void validateIfCanvasIsAlreadyPresent() {
		if(CanvasService.getCanvas() != null) {
			throw new CustomException(ApplicationExceptionCode.CANVAS_ALREADY_PRESENT);
		}
	}

	/**
	 * This method validates if the canvas has correct number of input params 
	 * and throws exception if this validation is violated.
	 * @param inputArray
	 */
	private void validateIfCanvasHasCorrectNumberOfInputParams(String[] inputArray) {
		if(inputArray.length != 3) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_CANVAS_INPUT_PARAMS);
		}
	}

	/**
	 * This method validates if the canvas input point is integer 
	 * and throws exception if this validation is violated.
	 * @param inputArray
	 */
	private void validateIfTheCanvasInputPointIsInteger(String[] inputArray) {
		if(!GenericUtils.isInteger(inputArray[1], inputArray[2]) ) {
			throw new CustomException(ApplicationExceptionCode.CANVAS_INPUT_SHOULD_BE_INTEGER);
		}
	}
}
