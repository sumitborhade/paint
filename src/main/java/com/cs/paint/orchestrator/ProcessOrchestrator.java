package com.cs.paint.orchestrator;

/**
 * Single Responsibility purpose: To modify if new step like Validation and Creation need to be added
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class ProcessOrchestrator {

	/**
	 * This method orchestrate various steps involved in the application.
	 * Here it performs 2 main things 
	 * 1. Input Validation
	 * 2. Shape creation
	 * 
	 * @param inputString
	 * @return
	 */
	public boolean orchestrateProcess(String inputString) {
		//1. Validation
		ShapeValidatorOrchestrator validationOrchestrator = new ShapeValidatorOrchestrator();
		validationOrchestrator.performValidation(inputString);
		
		//2. Shape creation
		ShapeCreatorOrchestrator shapeCreationOrchestrator = new ShapeCreatorOrchestrator();
		boolean isShapeCreated = shapeCreationOrchestrator.createShape(inputString);
		
		return isShapeCreated;
	}
}
