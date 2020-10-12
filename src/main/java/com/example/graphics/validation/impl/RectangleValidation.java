package com.example.graphics.validation.impl;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validation.Validation;

public class RectangleValidation implements Validation {
	
	@Override
	public boolean validate(String[] inputArray) {
		if(inputArray.length != 5) {
			throw new CustomException(ExceptionCode.INCORRECT_RECTANGLE_INPUT_PARAMS);
		}
		
		if(!GenericUtils.isInteger(inputArray[1], inputArray[2], inputArray[3], inputArray[4])  ) {
			throw new CustomException(ExceptionCode.RECTANGLE_INPUT_SHOULD_BE_INTEGER);
		}
		return true;
	}
}
