package com.example.graphics.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;

public class GenericUtils {

	public static boolean isInteger(String... stringNumbers) {
		boolean isInteger = false;
		if (stringNumbers != null) {
			Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

			for (String stringNumber : stringNumbers) {
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
		if(s != null && !s.trim().equals("")) {
			System.out.println("Values less than 1 are " + s);
		}
		return intValuesLessThanOneList.size() > 0;
	}
	
	public static boolean isStringValueLessThanOne(String... stringValues) {
		List<Integer> integerList = Stream.of(stringValues).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		Integer[] intValues = integerList.toArray(new Integer[integerList.size()]);
		return isValueLessThanOne(intValues);
	}

	public static boolean checkIfThePointIsInsideCanvas(Point... points) {
		boolean isPointInsideCanvas = true;
		String[][] canvas = CanvasCreationService.getCanvas();
	
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
			
			if(pointX > canvasInternalWidth || pointY > canvasInternalHeight) {
				isPointInsideCanvas = false;
				System.out.println(point + " is outside of canvas.");
				break;
			}
		}
		
		return isPointInsideCanvas;
	}
}