package com.cs.paint.factory;

import java.util.HashMap;
import java.util.Map;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.ValidatorService;
import com.cs.paint.service.validator.impl.BucketFillValidator;
import com.cs.paint.service.validator.impl.CanvasValidator;
import com.cs.paint.service.validator.impl.LineValidator;
import com.cs.paint.service.validator.impl.RectangleValidator;

/**
 * Purpose to modify this class: When new validator entity class is created and it needs to be added.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class ShapeValidatorFactory {
	
	/**
	 * As the method inside the class is static,
	 * the object of this class is not required.
	 * 
	 * Making the constructor private to refrain creation of instance.
	 * 
	 */
	private ShapeValidatorFactory() {
	}
	
	/**
	 * Validator Entities Map is declared and loaded when the class is loaded.
	 * 
	 * Used static on purpose to ensure that the map is loaded only once.
	 * 
	 */
	private static Map<String, ValidatorService> validatorEntitiesMap = new HashMap<>();
	
	static {
		validatorEntitiesMap.put("C", new CanvasValidator());
		validatorEntitiesMap.put("L", new LineValidator());
		validatorEntitiesMap.put("R", new RectangleValidator());
		validatorEntitiesMap.put("B", new BucketFillValidator());
	}
	
	/**
	 * Factory pattern is used to ensure that single responsibility principle is applied. 
	 * This will avoid if-else conditions and will help to segregate Line, Rectangle, Canvas and Bucket fill from each other.
	 *
	 * This approach empower use to ensure that this class is touched only if new validator entry is added.
	 * 
	 * The logic which is applied when a new validator is added in such a way the previously tested validators will not be touch/modified.
	 * 
	 * @param inputType
	 * @return
	 */
	public static ValidatorService getValidatorEntity(String inputType) {
		if (inputType == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		return validatorEntitiesMap.get(inputType.toUpperCase());
	}
}
