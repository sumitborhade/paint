package com.cs.paint.factory;

import java.util.HashMap;
import java.util.Map;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.ShapeService;
import com.cs.paint.service.creator.impl.BucketFillService;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.service.creator.impl.LineService;
import com.cs.paint.service.creator.impl.RectangleService;

public class ShapeCreatorFactory {
	
	private static Map<String, ShapeService> validationEntitiesMap = new HashMap<>();
	
	static {
		validationEntitiesMap.put("C", new CanvasService());
		validationEntitiesMap.put("L", new LineService());
		validationEntitiesMap.put("R", new RectangleService());
		validationEntitiesMap.put("B", new BucketFillService());
	}
	
	public static ShapeService getShapeEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
