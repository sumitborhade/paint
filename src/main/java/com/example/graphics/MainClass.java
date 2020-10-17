package com.example.graphics;

import java.util.Scanner;

import com.example.graphics.creator.service.impl.CanvasService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.orchestrator.ShapeCreationOrchestrator;
import com.example.graphics.orchestrator.ValidationOrchestrator;

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
					ValidationOrchestrator validationOrchestrator = new ValidationOrchestrator();
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
