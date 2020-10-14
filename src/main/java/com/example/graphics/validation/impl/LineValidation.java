package com.example.graphics.validation.impl;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validation.Validation;

public class LineValidation implements Validation {

	@Override
	public boolean validate(String[] inputArray) {
		if (inputArray.length != 5) {
			throw new CustomException(ApplicationStatusCode.INCORRECT_LINE_INPUT_PARAMS);
		}

		if (!GenericUtils.isInteger(inputArray[1], inputArray[2], inputArray[3], inputArray[4])) {
			throw new CustomException(ApplicationStatusCode.LINE_INPUT_SHOULD_BE_INTEGER);
		}
		
		if(GenericUtils.isStringValueLessThanOne(inputArray[1], inputArray[2], inputArray[3], inputArray[4])) {
			throw new CustomException(ApplicationStatusCode.INCORRECT_LINE_INPUT_VALUE);
		}
		
		Point startPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		Point endPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		
		GenericUtils.checkIfThePointIsInsideCanvas(startPoint, endPoint);

		return true;
	}
	
	
}