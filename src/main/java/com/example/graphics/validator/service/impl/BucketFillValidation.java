package com.example.graphics.validator.service.impl;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validator.service.Validator;

public class BucketFillValidation implements Validator {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointsAreInteger(inputArray);
		validateIfTheFillPointIsInsideCanvas(inputArray);
		return true;
	}

	private void validateIfThePointsAreInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2])) {
			throw new CustomException(ApplicationWarningCode.BUCKET_FILL_INPUT_SHOULD_BE_INTEGER);
		}
	}

	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 4) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_BUCKET_FILL_INPUT_PARAMS);
		}
	}
	
	private void validateIfTheFillPointIsInsideCanvas(String[] inputArray) {
		Point fillPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		boolean isFillPointIsInsideCanvas = GenericUtils.checkIfThePointIsInsideCanvas(fillPoint);
		
		if(!isFillPointIsInsideCanvas) {
			throw new CustomException(ApplicationWarningCode.BUCKET_FILL_COORDINATE_OUT_OF_CANVAS);
		}
	}

}