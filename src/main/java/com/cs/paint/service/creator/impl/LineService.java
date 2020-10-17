package com.cs.paint.service.creator.impl;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.service.ShapeService;

public class LineService implements ShapeService {

	@Override
	public boolean createShape(String[] inputArray) {
		PointModel startPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		PointModel endPoint = new PointModel(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));

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