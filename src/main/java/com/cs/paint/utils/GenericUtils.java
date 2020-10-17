package com.cs.paint.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.creator.service.impl.CanvasService;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.Point;

public class GenericUtils {

	public static boolean isInteger(String... stringNumbers) {
		boolean isInteger = false;
		if (stringNumbers != null) {
			Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

			for (String stringNumber : stringNumbers) {
				if(stringNumber == null) {
					throw new CustomException(ApplicationWarningCode.NULL_INPUT);
				}
				
				isInteger = pattern.matcher(stringNumber).matches();
				
				if(!isInteger) {
					break;
				}
			}
		}

		return isInteger;
	}

	public static boolean isValueLessThanOne(Integer... intValues) {
		List<Integer> intValuesLessThanOneList= new ArrayList<>();
		
		for (int intValue : intValues) {
			if(intValue < 1) {
				intValuesLessThanOneList.add(intValue);
			}
		}
		
		String s = intValuesLessThanOneList.stream().map(Object::toString).collect(Collectors.joining(", "));
		if(!s.trim().equals("")) {
			System.out.println("Values less than 1 are " + s);
		}
		return intValuesLessThanOneList.size() > 0;
	}
	
	public static boolean checkIfThePointIsInsideCanvas(Point... points) {
		boolean isPointInsideCanvas = true;
		String[][] canvas = CanvasService.getCanvas();
	
		if(canvas == null) {
			throw new CustomException(ApplicationWarningCode.CANVAS_NOT_PRESENT);
		}
		
		int canvasInternalWidth = canvas.length - 2;
		int canvasInternalHeight = canvas[0].length - 2;
	
//		System.out.println("Width :: " + canvasInternalWidth);
//		System.out.println("Height :: " + canvasInternalHeight);
		
		for (Point point : points) {
			int pointX = point.getX();
			int pointY = point.getY();
			
			if (pointX <= 0 || pointY <= 0 || pointX > canvasInternalWidth || pointY > canvasInternalHeight) {
				isPointInsideCanvas = false;
				System.out.println(point + " is outside of canvas.");
				break;
			}
		}
		
		return isPointInsideCanvas;
	}
}