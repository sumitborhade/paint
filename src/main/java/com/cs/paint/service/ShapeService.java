package com.cs.paint.service;

/**
 * Single Responsibility purpose: This interface specifies a contract for creating a shape service.
 * 
 * This class also demonstrate Open-close principle. 
 * Once the class is created, it is closed for modification for other type of shapes. 
 * But a new class can be created to new shape without touching the existing classes.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public interface ShapeService {
	/**
	 * This method helps to specifies a contract on how the shape should be created.
	 * 
	 * @param inputArray
	 * @return
	 */
	boolean createShape(String[] inputArray);
}
