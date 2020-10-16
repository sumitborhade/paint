package com.example.graphics.factory;

import java.util.HashMap;
import java.util.Map;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.creator.service.impl.LineCreationService;
import com.example.graphics.creator.service.impl.RectangleCreationService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.validator.service.impl.BucketCreationService;

public class ShapeCreatorFactory {

	private static Map<String, ShapeCreator> validationEntitiesMap = new HashMap<>();
	
	static {
		validationEntitiesMap.put("C", new CanvasCreationService());
		validationEntitiesMap.put("L", new LineCreationService());
		validationEntitiesMap.put("R", new RectangleCreationService());
		validationEntitiesMap.put("B", new BucketCreationService());
	}
	
	public static ShapeCreator getShapeEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationWarningCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
