package com.example.graphics.constants;

/**
 * This enum contains the list of all the application status codes. 
 * The entries inside will be used to highlight any warning/exception 
 *
 */
public enum ApplicationWarningCode {
	
	//Generic
	NULL_INPUT("The input is null"),
	INCORRECT_DESIGN_TYPE("Design type entered is incorrect."),
	
	//Canvas
	INCORRECT_CANVAS_INPUT_PARAMS("# of Input params Canvas should be 3."),
	INCORRECT_CANVAS_INPUT_VALUE("Width/height of canvas should be great than 1."),
	CANVAS_NOT_PRESENT("Canvas has not been created. Please create it first."),
	CANVAS_ALREADY_PRESENT("Only one canvas can be created."),
	CANVAS_INPUT_SHOULD_BE_INTEGER("2nd and 3rd params of a Canvas should be integer."),
	
	//Line
	INCORRECT_LINE_INPUT_PARAMS("# of Input params Line should be 5."),
	LINE_INPUT_SHOULD_BE_INTEGER("2nd, 3rd, 4th and 5th params of a Line should be integer."),
	INVALID_LINE_POINTS("Only horizontal or vertical line can be drawn. Please recheck the points."),
	INCORRECT_LINE_INPUT_VALUE("X & Y co-ordinates of Line should be great than 1."),
	
	//Rectangle
	INCORRECT_RECTANGLE_INPUT_PARAMS("# of Input params Rectangle should be 5."),
	RECTANGLE_INPUT_SHOULD_BE_INTEGER("2nd, 3rd, 4th and 5th params of a Rectangle should be integer."),
	INCORRECT_RECTANGLE_INPUT_VALUE("X & Y co-ordinates for all points of Rectangle should be great than 1."),
	RECTANGLE_CO_ORDS_OUT_OF_CANVAS("At least one of the Rectangle points is out of canvas."),
	
	//Bucket fill
	INCORRECT_BUCKET_INPUT_PARAMS("# of Input params Bucket should be 4."),
	BUCKET_INPUT_SHOULD_BE_INTEGER("2nd and 3rd params of a Bucket should be integer."); 
	
	private String message;
	
	private ApplicationWarningCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
