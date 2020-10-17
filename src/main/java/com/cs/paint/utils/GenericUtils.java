package com.cs.paint.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.service.creator.impl.CanvasService;

/**
 * Single Responsibility purpose: To add only common utility method(s)
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class GenericUtils {
	
	/**
	 * As the utility methods inside the class are static,
	 * the object of this class is not required.
	 * 
	 * Making the constructor private to refrain creation of instance.
	 * 
	 */
	private GenericUtils() {
	}
	
	/**
	 * This method accepts the one or many string numbers and checks if these strings are numeric or not.
	 * 
	 * @param stringNumbers
	 * @return
	 */
	public static boolean isInteger(String... stringNumbers) {
		boolean isInteger = false;
		if (stringNumbers != null) {
			Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

			for (String stringNumber : stringNumbers) {
				if(stringNumber == null) {
					throw new CustomException(ApplicationExceptionCode.NULL_INPUT);
				}
				
				isInteger = pattern.matcher(stringNumber).matches();
				
				if(!isInteger) {
					break;
				}
			}
		}

		return isInteger;
	}

	/***
	 * This method accepts the one or many integers and checks if these integers are less than one.
	 * 
	 * @param intValues
	 * @return
	 */
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
	
	/***
	 * This method accepts one or more points and return false if one of the them outside canvas.
	 *  
	 * @param points
	 * @return
	 */
	public static boolean checkIfThePointIsInsideCanvas(PointModel... points) {
		boolean isPointInsideCanvas = true;
		String[][] canvas = CanvasService.getCanvas();
	
		if(canvas == null) {
			throw new CustomException(ApplicationExceptionCode.CANVAS_NOT_PRESENT);
		}
		
		int canvasInternalWidth = canvas.length - 2;
		int canvasInternalHeight = canvas[0].length - 2;
	
//		System.out.println("Width :: " + canvasInternalWidth);
//		System.out.println("Height :: " + canvasInternalHeight);
		
		for (PointModel point : points) {
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