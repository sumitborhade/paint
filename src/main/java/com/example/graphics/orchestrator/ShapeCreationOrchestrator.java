package com.example.graphics.orchestrator;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.factory.ShapeCreatorFactory;
import com.example.graphics.shape.service.Shape;
import com.example.graphics.shape.service.impl.CanvasCreationService;

public class ShapeCreationOrchestrator {

	public boolean createShape(String inputString) {
		
		if (inputString == null) {
			throw new CustomException(ApplicationStatusCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		Shape shape = ShapeCreatorFactory.getShapeEntity(inputArray[0]);
		
		if(shape == null) {
			throw new CustomException(ApplicationStatusCode.INCORRECT_DESIGN_TYPE);
		}
		
		shape.createShape(inputArray);
		CanvasCreationService.printCanvas();
		
		return true;
	}
	
	
}
