package com.cs.paint.service.validator.impl;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.service.ValidatorService;
import com.cs.paint.utils.GenericUtils;

/**
 * Single Responsibility purpose: 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class BucketFillValidator implements ValidatorService {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointsAreInteger(inputArray);
		validateIfTheFillPointIsInsideCanvas(inputArray);
		return true;
	}

	private void validateIfThePointsAreInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2])) {
			throw new CustomException(ApplicationExceptionCode.BUCKET_FILL_INPUT_SHOULD_BE_INTEGER);
		}
	}

	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 4) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_BUCKET_FILL_INPUT_PARAMS);
		}
	}
	
	private void validateIfTheFillPointIsInsideCanvas(String[] inputArray) {
		PointModel fillPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		boolean isFillPointIsInsideCanvas = GenericUtils.checkIfThePointIsInsideCanvas(fillPoint);
		
		if(!isFillPointIsInsideCanvas) {
			throw new CustomException(ApplicationExceptionCode.BUCKET_FILL_COORDINATE_OUT_OF_CANVAS);
		}
	}

}