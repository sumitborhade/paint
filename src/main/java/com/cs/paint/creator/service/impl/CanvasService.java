package com.cs.paint.creator.service.impl;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.creator.service.ShapeCreator;
import com.cs.paint.exception.CustomException;
import com.cs.paint.utils.GenericUtils;

public class CanvasService implements ShapeCreator {

	private static String[][] canvas;
	
	public boolean createCanvas(int width, int height) {
		boolean wasCanvasPresentEarlier = true;

		if (canvas == null) {
			synchronized (CanvasService.class) {
				if (canvas == null) {
					wasCanvasPresentEarlier = false;
					if (GenericUtils.isValueLessThanOne(width, height)) {
						throw new CustomException(ApplicationWarningCode.INCORRECT_CANVAS_INPUT_VALUE);
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
			throw new CustomException(ApplicationWarningCode.CANVAS_ALREADY_PRESENT);
		}
		
		return true;
	}

	public static String[][] getCanvas() {
		return canvas;
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