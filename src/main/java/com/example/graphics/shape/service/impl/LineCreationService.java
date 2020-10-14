package com.example.graphics.shape.service.impl;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.shape.service.Shape;

public class LineCreationService implements Shape {

	@Override
	public boolean createShape(String[] inputArray) {
		Point startPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		Point endPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));

		boolean isLineCreated = true;
		
		if (startPoint.getX() != endPoint.getX() && startPoint.getY() != endPoint.getY()) {
			isLineCreated = false;
			throw new CustomException(ApplicationStatusCode.INVALID_LINE_POINTS);
		}
		
		String[][] canvas = CanvasCreationService.getCanvas();
		
		for (int counterY = startPoint.getX(); counterY <= endPoint.getX(); counterY++) {
			for (int counterX = startPoint.getY(); counterX <= endPoint.getY(); counterX++) {
				canvas[counterY][counterX] = "x";
			}
		}
		
		return isLineCreated;
	}

}