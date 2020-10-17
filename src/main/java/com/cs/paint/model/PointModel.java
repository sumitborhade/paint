package com.cs.paint.model;

/**
 * Single Responsibility purpose: To modify the Point model related behavior.
 * 
 * Encapsulation (Object oriented principle) is implemented here.
 * 
 * This class has 2 co-ordinates x and y and this provides getter, setter methods along with toString method 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public class PointModel {

	private int x;

	private int y;
	
	public PointModel(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}