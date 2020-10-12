package com.example.graphics.validation.impl;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validation.Validation;

public class BucketValidation implements Validation {
	
	@Override
	public boolean validate(String[] inputArray) {
		if(inputArray.length != 4) {
			throw new CustomException(ExceptionCode.INCORRECT_BUCKET_INPUT_PARAMS);
		}
		
		if(!GenericUtils.isInteger(inputArray[1], inputArray[2])  ) {
			throw new CustomException(ExceptionCode.BUCKET_INPUT_SHOULD_BE_INTEGER);
		}
		return true;
	}
}
