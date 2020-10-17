package com.cs.paint.factory;

import java.util.HashMap;
import java.util.Map;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.creator.service.ShapeService;
import com.cs.paint.creator.service.impl.BucketFillService;
import com.cs.paint.creator.service.impl.CanvasService;
import com.cs.paint.creator.service.impl.LineService;
import com.cs.paint.creator.service.impl.RectangleService;
import com.cs.paint.exception.CustomException;

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
			throw new CustomException(ApplicationWarningCode.NULL_INPUT);
		}
		
		return validationEntitiesMap.get(inputType.toUpperCase());
	}
}
