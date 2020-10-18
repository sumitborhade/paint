package com.cs.paint.orchestrator;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeCreatorFactory;
import com.cs.paint.service.ShapeService;
import com.cs.paint.service.creator.impl.CanvasService;

/**
 * Single Responsibility purpose: Modify this class if any creation related step need to be added.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class ShapeCreatorOrchestrator {

	/**
	 * This method accepts the input string and splits it in input array.
	 * 
	 * According to the first element of the array, appropriate creator is called to create required shape.
	 * 
	 * If the input is incorrect the appropriate custom runtime exception is thrown.  
	 * 
	 * @param inputString
	 * @return
	 */
	public boolean createShape(String inputString) {
		
		if (inputString == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		ShapeService shape = ShapeCreatorFactory.getShapeCreatorEntity(inputArray[0]);
		
		if(shape == null) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_DESIGN_TYPE);
		}
		
		//Dynamic polymorphism
		shape.createShape(inputArray);
		CanvasService.printCanvas();
		
		return true;
	}
	
	
}
