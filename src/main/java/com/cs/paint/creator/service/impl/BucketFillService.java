package com.cs.paint.creator.service.impl;

import com.cs.paint.creator.service.ShapeService;
import com.cs.paint.model.PointModel;

public class BucketFillService implements ShapeService {

	@Override
	public boolean createShape(String[] inputArray) {
		PointModel fillPoint = new PointModel(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		String color = inputArray[3];
		String[][] canvas = CanvasService.getCanvas();
		String colorToReplace = canvas[fillPoint.getX()][fillPoint.getY()];
		colorTheCell(canvas, fillPoint, color, colorToReplace);
		return true;
	}
	
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