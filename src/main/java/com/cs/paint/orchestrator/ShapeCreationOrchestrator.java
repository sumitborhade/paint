package com.cs.paint.orchestrator;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.creator.service.ShapeCreator;
import com.cs.paint.creator.service.impl.CanvasService;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeCreatorFactory;

public class ShapeCreationOrchestrator {

	public boolean createShape(String inputString) {
		
		if (inputString == null) {
			throw new CustomException(ApplicationWarningCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		ShapeCreator shape = ShapeCreatorFactory.getShapeEntity(inputArray[0]);
		
		if(shape == null) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_DESIGN_TYPE);
		}
		
		shape.createShape(inputArray);
		CanvasService.printCanvas();
		
		return true;
	}
	
	
}
