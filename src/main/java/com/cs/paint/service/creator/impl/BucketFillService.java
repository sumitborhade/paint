package com.cs.paint.service.creator.impl;

import com.cs.paint.model.PointModel;
import com.cs.paint.service.ShapeService;

/**
 * Single Responsibility purpose: To make change to this class if the any bucket fill behavior needs changes.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class BucketFillService implements ShapeService {

	/***
	 * This method accepts input array. It then finds the fill point and color to be filled.
	 * 
	 * It then calls a method to color the cells as required on a canvas.
	 * 
	 * @param inputArray
	 */
	public boolean createShape(String[] inputArray) {
		PointModel fillPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		String color = inputArray[3];
		String[][] canvas = CanvasService.getCanvas();
		String colorToReplace = canvas[fillPoint.getX()][fillPoint.getY()];
		colorTheCell(canvas, fillPoint, color, colorToReplace);
		return true;
	}
	
	/***
	 * This method is called recursively to fill the specified color for required cells.
	 * 
	 * It basically finds and colors the cells by traversing through left, right, up and bottom cells starting from the fill point.
	 * 
	 * Exit condition from the recursion is if the existing object or wall of the canvas is found. 
	 * 
	 * @param canvas
	 * @param fillPoint
	 * @param color
	 * @param colorToReplace
	 * @return
	 */
	public String[][] colorTheCell(String[][] canvas, PointModel fillPoint, String color, String colorToReplace) {
		
		int x = fillPoint.getX();
		int y = fillPoint.getY();
		
		int canvasInternalWidth = canvas.length - 2;
		int canvasInternalHeight = canvas[0].length - 2;

		if (!canvas[x][y].equals(colorToReplace) || x <= 0 || y <= 0 || x > canvasInternalWidth
				|| y > canvasInternalHeight) {
			return canvas;
		}

		canvas[x][y] = color;
		
		// Left point
		colorTheCell(canvas, new PointModel(x - 1, y), color, colorToReplace);
		// Right point
		colorTheCell(canvas, new PointModel(x + 1, y), color, colorToReplace);
		// Top point
		colorTheCell(canvas, new PointModel(x, y + 1), color, colorToReplace);
		// Bottom point
		colorTheCell(canvas, new PointModel(x, y - 1), color, colorToReplace);
		
		return canvas;
	}

}