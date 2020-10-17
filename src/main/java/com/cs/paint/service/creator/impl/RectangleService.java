package com.cs.paint.service.creator.impl;

import com.cs.paint.model.PointModel;
import com.cs.paint.service.ShapeService;

/**
 * Single Responsibility purpose: To make change to this class if the any rectangle related behavior needs changes.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class RectangleService implements ShapeService {

	/***
	 * This method accepts input array. It then finds the all four points of a rectangle.
	 * On the basic of these 4 points, it finds all 4 lines required to draw a rectangle.
	 * It calls the create shape for line to draw the rectangle.
	 * 
	 * @param inputArray
	 */
	@Override
	public boolean createShape(String[] inputArray) {
		
		PointModel upperLeftPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		PointModel lowerRightPoint = new PointModel(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		PointModel upperRightPoint = new PointModel(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[2]));
		PointModel lowerLeftPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[4]));
		
		ShapeService line = new LineService();
		
		String upperHorizontalLine = "L " + upperLeftPoint.getX() + " " + upperLeftPoint.getY() + " "
				+ upperRightPoint.getX() + " " + upperRightPoint.getY();
		
		String lowerHorizontalLine = "L " + lowerLeftPoint.getX() + " " + lowerLeftPoint.getY() + " "
				+ lowerRightPoint.getX() + " " + lowerRightPoint.getY();
		
		String leftVerticalLine = "L " + upperLeftPoint.getX() + " " + upperLeftPoint.getY() + " "
				+ lowerLeftPoint.getX() + " " + lowerLeftPoint.getY();
		
		String rightVerticalLine = "L " + upperRightPoint.getX() + " " + upperRightPoint.getY() + " "
				+ lowerRightPoint.getX() + " " + lowerRightPoint.getY();
		
		//Line code is reused to draw rectangle
		line.createShape(upperHorizontalLine.split(" "));
		line.createShape(lowerHorizontalLine.split(" "));
		line.createShape(leftVerticalLine.split(" "));
		line.createShape(rightVerticalLine.split(" "));
		
		return true;
	}

}
