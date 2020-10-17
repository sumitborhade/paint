package com.cs.paint.service;

/**
 * Single Responsibility purpose: This interface specifies a contract for valiating given input for a specified shape.
 * 
 * This class also demonstrate Open-close principle. 
 * Once the class is created, it is closed for modification for other type of shape validators. 
 * But a new class can be created to new shape validator without touching the existing classes.
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public interface ValidatorService {
	public boolean validate(String[] inputArray);
}