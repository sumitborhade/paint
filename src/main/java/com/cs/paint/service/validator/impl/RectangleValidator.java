package com.cs.paint.service.validator.impl;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.service.ValidatorService;
import com.cs.paint.utils.GenericUtils;

/**
 * Single Responsibility purpose: To make change to this class if the any rectangle validation needs to be changed or added. 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class RectangleValidator implements ValidatorService {

	/***
	 * It accepts input and triggers various methods to perform validations.
	 */
	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointsAreInteger(inputArray);
		validateIfRectanglePointsAreWithinCanvas(inputArray);
		return true;
	}
	
	/**
	 * This method validates if the number of parameters for rectangle are 5 
	 * and throws exception if this validation is violated.
	 * @param inputArray
	 */
	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 5) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_RECTANGLE_INPUT_PARAMS);
		}
	}

	/**
	 * This method validates if the input rectangle points are integer 
	 * and throws exception if this validation is violated.
	 * @param inputArray
	 */
	private void validateIfThePointsAreInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2], inputArray[3], inputArray[4])) {
			throw new CustomException(ApplicationExceptionCode.RECTANGLE_INPUT_SHOULD_BE_INTEGER);
		}
	}

	/**
	 * This method validates if the input rectangle points are inside canvas  
	 * and throws exception if this validation is violated.
	 * @param inputArray
	 */
	private void validateIfRectanglePointsAreWithinCanvas(String[] inputArray) {
		PointModel startPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		PointModel endPoint = new PointModel(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		boolean isRectanglePointsAreWithinCanvas = GenericUtils.checkIfThePointIsInsideCanvas(startPoint, endPoint);
		
		if(!isRectanglePointsAreWithinCanvas) {
			throw new CustomException(ApplicationExceptionCode.RECTANGLE_COORDINATE_OUT_OF_CANVAS);
		}
	}
}