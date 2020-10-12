package com.example.graphics.shape.service.impl;

import com.example.graphics.model.Point;
import com.example.graphics.shape.service.Shape;

public class RectangleCreationService implements Shape {

	@Override
	public boolean createShape(String[] inputArray) {
		
		Point upperLeftPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		Point lowerRightPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		Point upperRightPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[2]));
		Point lowerLeftPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[4]));
		
		Shape line = new LineCreationService();
		
		String upperHorizontalLine = "L " + upperLeftPoint.getX() + " " + upperLeftPoint.getY() + " "
				+ upperRightPoint.getX() + " " + upperRightPoint.getY();
		
		String lowerHorizontalLine = "L " + lowerLeftPoint.getX() + " " + lowerLeftPoint.getY() + " "
				+ lowerRightPoint.getX() + " " + lowerRightPoint.getY();
		
		String leftVerticalLine = "L " + upperLeftPoint.getX() + " " + upperLeftPoint.getY() + " "
				+ lowerLeftPoint.getX() + " " + lowerLeftPoint.getY();
		
		String rightVerticalLine = "L " + upperRightPoint.getX() + " " + upperRightPoint.getY() + " "
				+ lowerRightPoint.getX() + " " + lowerRightPoint.getY();
		
		line.createShape(upperHorizontalLine.split(" "));
		line.createShape(lowerHorizontalLine.split(" "));
		line.createShape(leftVerticalLine.split(" "));
		line.createShape(rightVerticalLine.split(" "));
		
		return false;
	}

}
