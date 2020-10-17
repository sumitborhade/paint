package com.cs.paint.service.validator.impl;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.utils.GenericUtils;
import com.cs.paint.validator.service.Validator;

public class RectangleValidator implements Validator {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointsAreInteger(inputArray);
		validateIfRectanglePointsAreWithinCanvas(inputArray);
		return true;
	}
	
	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 5) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_RECTANGLE_INPUT_PARAMS);
		}
	}

	private void validateIfThePointsAreInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2], inputArray[3], inputArray[4])) {
			throw new CustomException(ApplicationWarningCode.RECTANGLE_INPUT_SHOULD_BE_INTEGER);
		}
	}

	private void validateIfRectanglePointsAreWithinCanvas(String[] inputArray) {
		PointModel startPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		PointModel endPoint = new PointModel(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		boolean isRectanglePointsAreWithinCanvas = GenericUtils.checkIfThePointIsInsideCanvas(startPoint, endPoint);
		
		if(!isRectanglePointsAreWithinCanvas) {
			throw new CustomException(ApplicationWarningCode.RECTANGLE_COORDINATE_OUT_OF_CANVAS);
		}
	}
}