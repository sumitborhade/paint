package com.example.graphics.validator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.validator.service.Validator;
import com.example.graphics.validator.service.impl.RectangleValidation;

public class RectangleValidationTest {

	private Validator rectangleValidation;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		rectangleValidation = new RectangleValidation();
	}

	@After
	public void tearDown() throws Exception {
		rectangleValidation = null;
	}

	@Test
	public void testRectangleValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.INCORRECT_RECTANGLE_INPUT_PARAMS.getMessage());
		String[] rectangleInputArray = "L 100".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenInputIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.RECTANGLE_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] rectangleInputArray = "L 100 pp 200 20".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenPointCoordinatesAreZeroThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.RECTANGLE_CO_ORDS_OUT_OF_CANVAS.getMessage());
		String[] rectangleInputArray = "L 0 0 200 20".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenPointIsOutsideCanvasThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.RECTANGLE_CO_ORDS_OUT_OF_CANVAS.getMessage());
		String[] rectangleInputArray = "L 1 1 200 20".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		CanvasCreationService.destroyCanvas();
		CanvasCreationService canvasCreationService = new CanvasCreationService();
		canvasCreationService.createCanvas(20, 4);
		String[] rectangleInputArray = "L 16 3 18 4".split(" ");
		assertTrue("Rectangle validation should be successful.", rectangleValidation.validate(rectangleInputArray));
	}

}
