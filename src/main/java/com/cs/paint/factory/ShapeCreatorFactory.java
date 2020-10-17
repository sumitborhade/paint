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

/**
 * Purpose to modify this class: When new creator entity class is created and it needs to be added.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class ShapeCreatorFactory {
	
	/**
	 * As the method inside the class is static,
	 * the object of this class is not required.
	 * 
	 * Making the constructor private to refrain creation of instance.
	 *  
	 */
	private ShapeCreatorFactory() {
	}
	
	/**
	 * Creator Entities Map is declared and loaded when the class is loaded.
	 * 
	 * Used static on purpose to ensure that the map is loaded only once.
	 * 
	 */
	private static Map<String, ShapeService> creatorEntitiesMap = new HashMap<>();
	
	static {
		creatorEntitiesMap.put("C", new CanvasService());
		creatorEntitiesMap.put("L", new LineService());
		creatorEntitiesMap.put("R", new RectangleService());
		creatorEntitiesMap.put("B", new BucketFillService());
	}
	
	/**
	 * Factory pattern is used to ensure that single responsibility principle is applied. 
	 * This will avoid if-else conditions and will help to segregate Line, Rectangle, Canvas and Bucket fill from each other.
	 *
	 * This approach empower use to ensure that this class is touched only if new entry is added to shapes.
	 * 
	 * The logic which is applied when a new creator is added in such a way the previously tested creators will not be touch/modified.
	 * 
	 * @param inputType
	 * @return
	 */
	public static ShapeService getShapeCreatorEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		return creatorEntitiesMap.get(inputType.toUpperCase());
	}
}
