package com.cs.paint.factory;

import java.util.HashMap;
import java.util.Map;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.validator.impl.BucketFillValidator;
import com.cs.paint.service.validator.impl.CanvasValidator;
import com.cs.paint.service.validator.impl.LineValidator;
import com.cs.paint.service.validator.impl.RectangleValidator;
import com.cs.paint.validator.service.Validator;

public class ShapeValidatorFactory {
	
	private static Map<String, Validator> validationEntitiesMap = new HashMap<>();
	
	static {
		validationEntitiesMap.put("C", new CanvasValidator());
		validationEntitiesMap.put("L", new LineValidator());
		validationEntitiesMap.put("R", new RectangleValidator());
		validationEntitiesMap.put("B", new BucketFillValidator());
	}
	
	public static Validator getValidationEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
