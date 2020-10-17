package com.cs.paint.orchestrator;

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
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		boolean isShapeCreated = shapeCreationOrchestrator.createShape(inputString);
		
		return isShapeCreated;
	}
}
