package com.example.graphics.creator.service.impl;

import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.model.Point;

public class RectangleCreationService implements ShapeCreator {

	@Override
	public boolean createShape(String[] inputArray) {
		
		Point upperLeftPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		Point lowerRightPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		Point upperRightPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[2]));
		Point lowerLeftPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[4]));
		
		ShapeCreator line = new LineCreationService();
		
		String upperHorizontalLine = "L " + upperLeftPoint.getX() + " " + upperLeftPoint.getY() + " "
				+ upperRightPoint.getX() + " " + upperRightPoint.getY();
		
		String lowerHorizontalLine = "L " + lowerLeftPoint.getX() + " " + lowerLeftPoint.getY() + " "
				+ lowerRightPoint.getX() + " " + lowerRightPoint.getY();
		
		String leftVerticalLine = "L " + upperLeftPoint.getX() + " " + upperLeftPoint.getY() + " "
				+ lowerLeftPoint.getX() + " " + lowerLeftPoint.getY();
		
		String rightVerticalLine = "L " + upperRightPoint.getX() + " " + upperRightPoint.getY() + " "
				+ lowerRightPoint.getX() + " " + lowerRightPoint.getY();
		
		boolean isUpperHorizontalLineCreated = line.createShape(upperHorizontalLine.split(" "));
		boolean isLowerHorizontalLine = line.createShape(lowerHorizontalLine.split(" "));
		boolean isLeftVerticalLineCreated = line.createShape(leftVerticalLine.split(" "));
		boolean isRightVerticalLineCreated = line.createShape(rightVerticalLine.split(" "));
		
		return (isUpperHorizontalLineCreated && isLowerHorizontalLine && isLeftVerticalLineCreated && isRightVerticalLineCreated);
	}

}
