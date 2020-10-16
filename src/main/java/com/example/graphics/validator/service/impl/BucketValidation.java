package com.example.graphics.validator.service.impl;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validator.service.Validator;

public class BucketValidation implements Validator {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointsAreInteger(inputArray);
		
		Point fillPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		GenericUtils.checkIfThePointIsInsideCanvas(fillPoint);
		
		return true;
	}

	private void validateIfThePointsAreInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2])) {
			throw new CustomException(ApplicationWarningCode.BUCKET_INPUT_SHOULD_BE_INTEGER);
		}
	}

	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 4) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_BUCKET_INPUT_PARAMS);
		}
	}

}