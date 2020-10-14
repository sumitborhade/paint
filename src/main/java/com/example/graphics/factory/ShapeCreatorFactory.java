package com.example.graphics.factory;

import java.util.HashMap;
import java.util.Map;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.Shape;
import com.example.graphics.shape.service.impl.BucketCreationService;
import com.example.graphics.shape.service.impl.CanvasCreationService;
import com.example.graphics.shape.service.impl.LineCreationService;
import com.example.graphics.shape.service.impl.RectangleCreationService;

public class ShapeCreatorFactory {

	private static Map<String, Shape> validationEntitiesMap = new HashMap<>();
	
	static {
		validationEntitiesMap.put("C", new CanvasCreationService());
		validationEntitiesMap.put("L", new LineCreationService());
		validationEntitiesMap.put("R", new RectangleCreationService());
		validationEntitiesMap.put("B", new BucketCreationService());
	}
	
	public static Shape getShapeEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationStatusCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
