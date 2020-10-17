package com.cs.paint;

import java.util.Scanner;

import com.cs.paint.exception.CustomException;
import com.cs.paint.orchestrator.ShapeCreationOrchestrator;
import com.cs.paint.orchestrator.ShapeValidatorOrchestrator;
import com.cs.paint.service.creator.impl.CanvasService;

/**
 * This is a entry point for Application.
 */
public class MainClass {
	
	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			while (true) {
				try {
					System.out.print("Enter command : ");
					String inputString = scan.nextLine();

					//Exit condition
					if(inputString != null && inputString.equalsIgnoreCase("q")) {
						CanvasService.destroyCanvas();
						break;
					}
					
					//1. Validation
					ShapeValidatorOrchestrator validationOrchestrator = new ShapeValidatorOrchestrator();
					validationOrchestrator.performValidation(inputString);
					
					//2. Shape creation
					ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
					shapeCreationOrchestrator.createShape(inputString);
					
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
			}//while end
		}
	}
}
