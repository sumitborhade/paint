package com.example.graphics;

import java.util.Scanner;

import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.impl.ShapeCreationOrchestrator;
import com.example.graphics.validation.impl.ValidationOrchestrator;

public class MainClass {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {

			while (true) {
				try {
					System.out.print("Enter command : ");
					String inputString = scan.nextLine();

					//Exit condition
					if(inputString != null && inputString.equalsIgnoreCase("q")) {
						break;
					}
					
					//1. Validation
					ValidationOrchestrator validationOrchestrator = new ValidationOrchestrator();
					validationOrchestrator.triggerValidation(inputString);
					
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
