package com.cs.paint.service.creator.impl;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.ShapeService;
import com.cs.paint.utils.GenericUtils;

/**
 * Single Responsibility purpose: To make change to this class if the any canvas related behavior needs changes.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class CanvasService implements ShapeService {

	private static String[][] canvas;
	
	/**
	 * Canvas is created using input width and height.
	 * Here, only one canvas can be created for a given run. 
	 * 
	 * Idea behind creating only canvas was derived from Singleton design pattern.
	 * Double locking mechanism, Synchronized block for multithreaded environment to avoid duplicate objects creation have been implemented  
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public boolean createCanvas(int width, int height) {
		boolean wasCanvasPresentEarlier = true;

		if (canvas == null) {
			synchronized (CanvasService.class) {
				if (canvas == null) {
					wasCanvasPresentEarlier = false;
					if (GenericUtils.isValueLessThanOne(width, height)) {
						throw new CustomException(ApplicationExceptionCode.INCORRECT_CANVAS_INPUT_VALUE);
					} else {
						width = width + 2;
						height = height + 2;
	
						canvas = new String[width][height];
						for (int j = 0; j < height; j++) {
							for (int i = 0; i < width; i++) {
								if (j == 0 || j == (height - 1)) {
									canvas[i][j] = "-";
								} else if (i == 0 || i == (width - 1)) {
									canvas[i][j] = "|";
								} else {
									canvas[i][j] = /* i + "," + j + */ " ";
								}
							}
						}
					}
				}
			}
		}

		if (wasCanvasPresentEarlier) {
			throw new CustomException(ApplicationExceptionCode.CANVAS_ALREADY_PRESENT);
		}
		
		return true;
	}

	/**
	 * Used to return the current canvas.
	 * 
	 * @return 2D Canvas array
	 */
	public static String[][] getCanvas() {
		return canvas;
	}

	/**
	 * Used for printing the current state of a canvas at any instance. 
	 * 
	 * @return
	 */
	public static boolean printCanvas() {
		String[][] canvas = getCanvas();
		int width = canvas.length;
		int height = canvas[0].length;

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				System.out.print(canvas[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n");
		return true;
	}

	/**
	 * It accepts given input String array and finds width and height.
	 * As per width & height, it then calls method to create canvas. 
	 */
	@Override
	public boolean createShape(String[] inputArray) {
		int width = Integer.parseInt(inputArray[1]);
		int height = Integer.parseInt(inputArray[2]);
		createCanvas(width, height);
		return true;
	}
	
	/**
	 * This method is called when application needs to be terminated gracefully.
	 */
	public static void destroyCanvas() {
		canvas = null;
	}
}