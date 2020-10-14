package com.example.graphics.orchestrator;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.factory.ShapeCreatorFactory;

public class ShapeCreationOrchestrator {

	public boolean createShape(String inputString) {
		
		if (inputString == null) {
			throw new CustomException(ApplicationStatusCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		ShapeCreator shape = ShapeCreatorFactory.getShapeEntity(inputArray[0]);
		
		if(shape == null) {
			throw new CustomException(ApplicationStatusCode.INCORRECT_DESIGN_TYPE);
		}
		
		shape.createShape(inputArray);
		CanvasCreationService.printCanvas();
		
		return true;
	}
	
	
}
