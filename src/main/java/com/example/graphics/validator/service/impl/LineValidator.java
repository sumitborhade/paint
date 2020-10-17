package com.example.graphics.validator.service.impl;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validator.service.Validator;

public class LineValidator implements Validator {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointsAreInteger(inputArray);
		validateIfTheLinePointsInsideCanvas(inputArray);
		return true;
	}

	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 5) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_LINE_INPUT_PARAMS);
		}
	}

	private void validateIfThePointsAreInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2], inputArray[3], inputArray[4])) {
			throw new CustomException(ApplicationWarningCode.LINE_INPUT_SHOULD_BE_INTEGER);
		}
	}
	
	private void validateIfTheLinePointsInsideCanvas(String[] inputArray) {
		Point startPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		Point endPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		boolean isLinePointsAreInsideCanvas = GenericUtils.checkIfThePointIsInsideCanvas(startPoint, endPoint);
		
		if(!isLinePointsAreInsideCanvas) {
			throw new CustomException(ApplicationWarningCode.LINE_COORDINATE_OUT_OF_CANVAS);
		}
	}
}