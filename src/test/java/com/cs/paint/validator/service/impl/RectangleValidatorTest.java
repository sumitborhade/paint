package com.cs.paint.validator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.ShapeService;
import com.cs.paint.service.ValidatorService;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.service.validator.impl.RectangleValidator;

/**
 * Single Responsibility purpose: To test RectangleValidator.java 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class RectangleValidatorTest {

	private ValidatorService rectangleValidation;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeService canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		rectangleValidation = new RectangleValidator();
	}

	@After
	public void tearDown() throws Exception {
		rectangleValidation = null;
	}

	@Test
	public void testRectangleValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_RECTANGLE_INPUT_PARAMS.getMessage());
		String[] rectangleInputArray = "L 100".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenInputIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.RECTANGLE_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] rectangleInputArray = "L 100 pp 200 20".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenPointCoordinatesAreZeroThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.RECTANGLE_COORDINATE_OUT_OF_CANVAS.getMessage());
		String[] rectangleInputArray = "L 0 0 200 20".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenPointIsOutsideCanvasThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.RECTANGLE_COORDINATE_OUT_OF_CANVAS.getMessage());
		String[] rectangleInputArray = "L 1 1 200 20".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		CanvasService.destroyCanvas();
		CanvasService canvasCreationService = new CanvasService();
		canvasCreationService.createCanvas(20, 4);
		String[] rectangleInputArray = "L 16 3 18 4".split(" ");
		assertTrue("Rectangle validation should be successful.", rectangleValidation.validate(rectangleInputArray));
	}

}
