package com.example.graphics.validator.service.impl;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.Validator;
import com.example.graphics.exception.CustomException;
import com.example.graphics.utils.GenericUtils;

public class BucketValidation implements Validator {
	
	@Override
	public boolean validate(String[] inputArray) {
		if(inputArray.length != 4) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_BUCKET_INPUT_PARAMS);
		}
		
		if(!GenericUtils.isInteger(inputArray[1], inputArray[2])  ) {
			throw new CustomException(ApplicationWarningCode.BUCKET_INPUT_SHOULD_BE_INTEGER);
		}
		return true;
	}
}
