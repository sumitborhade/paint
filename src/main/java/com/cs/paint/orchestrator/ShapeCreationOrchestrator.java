package com.cs.paint.orchestrator;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeCreatorFactory;
import com.cs.paint.service.ShapeService;
import com.cs.paint.service.creator.impl.CanvasService;

public class ShapeCreationOrchestrator {

	public boolean createShape(String inputString) {
		
		if (inputString == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		ShapeService shape = ShapeCreatorFactory.getShapeEntity(inputArray[0]);
		
		if(shape == null) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_DESIGN_TYPE);
		}
		
		shape.createShape(inputArray);
		CanvasService.printCanvas();
		
		return true;
	}
	
	
}
