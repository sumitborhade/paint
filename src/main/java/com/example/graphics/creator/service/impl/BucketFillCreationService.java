package com.example.graphics.creator.service.impl;

import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.model.Point;

public class BucketFillCreationService implements ShapeCreator {

	@Override
	public boolean createShape(String[] inputArray) {
		Point fillPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		String color = inputArray[3];
		String[][] canvas = CanvasService.getCanvas();
		String colorToReplace = canvas[fillPoint.getX()][fillPoint.getY()];
		colorTheCell(canvas, fillPoint, color, colorToReplace);
		return true;
	}
	
	public String[][] colorTheCell(String[][] canvas, Point fillPoint, String color, String colorToReplace) {
		
		int x = fillPoint.getX();
		int y = fillPoint.getY();
		
		int canvasInternalWidth = canvas.length - 2;
		int canvasInternalHeight = canvas[0].length - 2;

		if (!canvas[x][y].equals(colorToReplace) || x <= 0 || y <= 0 || x > canvasInternalWidth || y > canvasInternalHeight) {
			return canvas;
		}

		canvas[x][y] = color;
		
		// Left point
		colorTheCell(canvas, new Point(x - 1, y), color, colorToReplace);
		// Right point
		colorTheCell(canvas, new Point(x + 1, y), color, colorToReplace);
		// Top point
		colorTheCell(canvas, new Point(x, y + 1), color, colorToReplace);
		// Bottom point
		colorTheCell(canvas, new Point(x, y - 1), color, colorToReplace);
		
		return canvas;
	}

}