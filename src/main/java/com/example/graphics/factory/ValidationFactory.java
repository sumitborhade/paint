package com.example.graphics.factory;

import java.util.HashMap;
import java.util.Map;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.creator.service.Validator;
import com.example.graphics.exception.CustomException;
import com.example.graphics.validator.service.impl.BucketValidation;
import com.example.graphics.validator.service.impl.CanvasValidation;
import com.example.graphics.validator.service.impl.LineValidation;
import com.example.graphics.validator.service.impl.RectangleValidation;

public class ValidationFactory {
	
	private static Map<String, Validator> validationEntitiesMap = new HashMap<>();
	
	static {
		validationEntitiesMap.put("C", new CanvasValidation());
		validationEntitiesMap.put("L", new LineValidation());
		validationEntitiesMap.put("R", new RectangleValidation());
		validationEntitiesMap.put("B", new BucketValidation());
	}
	
	public static Validator getValidationEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationStatusCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
