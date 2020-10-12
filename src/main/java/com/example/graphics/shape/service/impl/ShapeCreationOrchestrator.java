package com.example.graphics.shape.service.impl;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.factory.ShapeCreatorFactory;
import com.example.graphics.shape.service.Shape;

public class ShapeCreationOrchestrator {

	public boolean createShape(String inputString) {
		
		if (inputString == null) {
			throw new CustomException(ExceptionCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		Shape shape = ShapeCreatorFactory.getShapeEntity(inputArray[0]);
		
		if(shape == null) {
			throw new CustomException(ExceptionCode.INCORRECT_DESIGN_TYPE);
		}
		
		shape.createShape(inputArray);
		CanvasCreationService.printCanvas();
		
		return true;
	}
	
	
}
