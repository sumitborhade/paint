package com.cs.paint.service.validator.impl;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.service.ValidatorService;
import com.cs.paint.utils.GenericUtils;

/**
 * Single Responsibility purpose: To make change to this class if the any bucket fill validation needs to be changed or added.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class BucketFillValidator implements ValidatorService {

	/***
	 * It accepts input and triggers various methods to perform validations.
	 */
	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointIsInteger(inputArray);
		validateIfTheFillPointIsInsideCanvas(inputArray);
		return true;
	}
	
	/**
	 * This method validates if the number of parameters for bucket fill are 4 
	 * and throws exception if this validation is violated.
	 * @param inputArray
	 */
	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 4) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_BUCKET_FILL_INPUT_PARAMS);
		}
	}

	/**
	 * This method validates if the fill point co-ordinates are integer 
	 * and throws exception if this validation is violated. 
	 * @param inputArray
	 */
	private void validateIfThePointIsInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2])) {
			throw new CustomException(ApplicationExceptionCode.BUCKET_FILL_INPUT_SHOULD_BE_INTEGER);
		}
	}

	/**
	 * This method validates if the fill point resides inside the canvas 
	 * and throws exception if this validation is violated.
	 * @param inputArray
	 */
	private void validateIfTheFillPointIsInsideCanvas(String[] inputArray) {
		PointModel fillPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		boolean isFillPointIsInsideCanvas = GenericUtils.checkIfThePointIsInsideCanvas(fillPoint);
		
		if(!isFillPointIsInsideCanvas) {
			throw new CustomException(ApplicationExceptionCode.BUCKET_FILL_COORDINATE_OUT_OF_CANVAS);
		}
	}

}