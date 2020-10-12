package com.example.graphics.factory;

import java.util.HashMap;
import java.util.Map;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.validation.Validation;
import com.example.graphics.validation.impl.BucketValidation;
import com.example.graphics.validation.impl.CanvasValidation;
import com.example.graphics.validation.impl.LineValidation;
import com.example.graphics.validation.impl.RectangleValidation;

public class ValidationFactory {
	
	private static Map<String, Validation> validationEntitiesMap = new HashMap<>();
	
	static {
		validationEntitiesMap.put("C", new CanvasValidation());
		validationEntitiesMap.put("L", new LineValidation());
		validationEntitiesMap.put("R", new RectangleValidation());
		validationEntitiesMap.put("B", new BucketValidation());
	}
	
	public static Validation getValidationEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ExceptionCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
