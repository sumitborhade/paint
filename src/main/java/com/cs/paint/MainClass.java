package com.cs.paint;

import java.util.Scanner;

import com.cs.paint.exception.CustomException;
import com.cs.paint.orchestrator.ProcessOrchestrator;
import com.cs.paint.service.creator.impl.CanvasService;

/**
 * Single Responsibility purpose: This is a main class and it has the entry point for Application.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class MainClass {

	/**
	 * This is the starting point of the Application. 
	 */
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.print("Enter command : ");
					String inputString = scan.nextLine();

					//Exit condition to terminate application gracefully.
					if(inputString != null && inputString.equalsIgnoreCase("q")) {
						CanvasService.destroyCanvas();
						break;
					}
					
					ProcessOrchestrator processOrchestrator = new ProcessOrchestrator();
					processOrchestrator.orchestrateProcess(inputString);
					
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
			}//while end
		}
	}
}
