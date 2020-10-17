package com.cs.paint.creator.service.impl;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.creator.service.ShapeCreator;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.Point;

public class LineCreationService implements ShapeCreator {

	@Override
	public boolean createShape(String[] inputArray) {
		Point startPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		Point endPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));

		boolean isLineCreated = true;
		
		if (startPoint.getX() != endPoint.getX() && startPoint.getY() != endPoint.getY()) {
			isLineCreated = false;
			throw new CustomException(ApplicationWarningCode.INVALID_LINE_POINTS);
		}
		
		String[][] canvas = CanvasService.getCanvas();
		
		for (int counterY = startPoint.getX(); counterY <= endPoint.getX(); counterY++) {
			for (int counterX = startPoint.getY(); counterX <= endPoint.getY(); counterX++) {
				canvas[counterY][counterX] = "x";
			}
		}
		
		return isLineCreated;
	}

}