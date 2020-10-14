package com.example.graphics.shape.service.impl;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.Shape;
import com.example.graphics.utils.GenericUtils;

public class CanvasCreationService implements Shape {

	private static String[][] canvas;
	
	public boolean createCanvas(int width, int height) {
		boolean wasCanvasPresentEarlier = true;

		if (canvas == null) {
			synchronized (CanvasCreationService.class) {
				if (canvas == null) {
					wasCanvasPresentEarlier = false;
					if (GenericUtils.isValueLessThanOne(width, height)) {
						throw new CustomException(ApplicationStatusCode.INCORRECT_CANVAS_INPUT_VALUE);
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
			throw new CustomException(ApplicationStatusCode.CANVAS_ALREADY_PRESENT);
		}
		
		return true;
	}

	public static String[][] getCanvas() {
		return (canvas != null) ? canvas.clone() : canvas;
	}

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

	@Override
	public boolean createShape(String[] inputArray) {
		int width = Integer.parseInt(inputArray[1]);
		int height = Integer.parseInt(inputArray[2]);
		createCanvas(width, height);
		return true;
	}
	
	public static void destroyCanvas() {
		canvas = null;
	}
}