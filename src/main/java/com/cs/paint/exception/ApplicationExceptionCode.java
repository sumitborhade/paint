package com.cs.paint.exception;

/**
 * Single Responsibility purpose: Adding new Application Exception code
 * 
 * This enum contains the list of all the application status codes. 
 * The entries inside will be used to highlight any warning/exception 
 *
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 */
public enum ApplicationExceptionCode {
	
	//Generic
	NULL_INPUT("The input is null"),
	INCORRECT_DESIGN_TYPE("Design type entered is incorrect."),
	
	//Canvas
	INCORRECT_CANVAS_INPUT_PARAMS("Number of input params for canvas should be 3."),
	INCORRECT_CANVAS_INPUT_VALUE("Width/height of canvas should be great than 1."),
	CANVAS_NOT_PRESENT("Canvas has not been created. Please create it first."),
	CANVAS_ALREADY_PRESENT("Only one canvas can be created."),
	CANVAS_INPUT_SHOULD_BE_INTEGER("2nd and 3rd params of a canvas should be integer."),
	
	//Line
	INCORRECT_LINE_INPUT_PARAMS("Number of input params line should be 5."),
	LINE_INPUT_SHOULD_BE_INTEGER("2nd, 3rd, 4th and 5th params of a line should be integer."),
	INVALID_LINE_POINTS("Only horizontal or vertical line can not be drawn. Please recheck the points."),
	LINE_COORDINATE_OUT_OF_CANVAS("X & Y co-ordinates of Line should be great than 1."),
	
	//Rectangle
	INCORRECT_RECTANGLE_INPUT_PARAMS("Number of input params rectangle should be 5."),
	RECTANGLE_INPUT_SHOULD_BE_INTEGER("2nd, 3rd, 4th and 5th params of a rectangle should be integer."),
	RECTANGLE_COORDINATE_OUT_OF_CANVAS("At least one of the rectangle points is out of canvas."),
	
	//Bucket fill
	INCORRECT_BUCKET_FILL_INPUT_PARAMS("Number of input params Bucket fill should be 4."),
	BUCKET_FILL_INPUT_SHOULD_BE_INTEGER("2nd and 3rd params of a Bucket should be integer."),
	BUCKET_FILL_COORDINATE_OUT_OF_CANVAS("Bucket fill point should be within canvas."); 
	
	private String message;
	
	private ApplicationExceptionCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
