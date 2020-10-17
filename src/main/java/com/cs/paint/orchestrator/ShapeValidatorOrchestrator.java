package com.cs.paint.orchestrator;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeValidatorFactory;
import com.cs.paint.service.ValidatorService;

/**
 * Single Responsibility purpose: Modify this class if any validator related step need to be added.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class ShapeValidatorOrchestrator {

	/**
	 * This method accepts the input string and splits it in input array.
	 * 
	 * According to the first element of the array, appropriate validator is called to validate the input.
	 * 
	 * If the input is incorrect the appropriate custom runtime exception is thrown.  
	 * 
	 * @param inputString
	 * @return
	 */
	public boolean performValidation(String inputString) {
		if (inputString == null) {
			throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
		}
		
		String[] inputArray = inputString.split(" ");
		
		ValidatorService validation = ShapeValidatorFactory.getValidatorEntity(inputArray[0]);
		
		if(validation == null) {
			throw new CustomException(ApplicationExceptionCode.INCORRECT_DESIGN_TYPE);
		}
		//Dynamic polymorphism
		return validation.validate(inputArray);
	}
	
	
}
