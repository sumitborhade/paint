package com.cs.paint.factory;

import java.util.HashMap;
import java.util.Map;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.validator.service.Validator;
import com.cs.paint.validator.service.impl.BucketFillValidation;
import com.cs.paint.validator.service.impl.CanvasValidation;
import com.cs.paint.validator.service.impl.LineValidator;
import com.cs.paint.validator.service.impl.RectangleValidation;

public class ValidationFactory {
	
	private static Map<String, Validator> validationEntitiesMap = new HashMap<>();
	
	static {
		validationEntitiesMap.put("C", new CanvasValidation());
		validationEntitiesMap.put("L", new LineValidator());
		validationEntitiesMap.put("R", new RectangleValidation());
		validationEntitiesMap.put("B", new BucketFillValidation());
	}
	
	public static Validator getValidationEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationWarningCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
