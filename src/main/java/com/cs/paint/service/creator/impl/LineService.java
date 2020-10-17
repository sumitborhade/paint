package com.cs.paint.service.creator.impl;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.service.ShapeService;

/**
 * Single Responsibility purpose: To make change to this class if the any line related behavior needs changes.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class LineService implements ShapeService {

	/***
	 * This method accepts input array. It then finds the start and end point of a line.
	 * 
	 * It performs the operation to draw a line within a specified canvas.
	 * 
	 * @param inputArray
	 */
	@Override
	public boolean createShape(String[] inputArray) {
		PointModel startPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		PointModel endPoint = new PointModel(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));

		boolean isLineCreated = true;
		
		if (startPoint.getX() != endPoint.getX() && startPoint.getY() != endPoint.getY()) {
			isLineCreated = false;
			throw new CustomException(ApplicationExceptionCode.INVALID_LINE_POINTS);
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