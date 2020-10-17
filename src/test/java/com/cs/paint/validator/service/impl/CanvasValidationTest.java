package com.cs.paint.validator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.service.validator.impl.CanvasValidator;
import com.cs.paint.validator.service.Validator;

public class CanvasValidationTest {

	private Validator canvasValidation;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		canvasValidation = new CanvasValidator();
	}

	@After
	public void tearDown() throws Exception {
		canvasValidation = null;
	}
	
	@Test
	public void testValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.INCORRECT_CANVAS_INPUT_PARAMS.getMessage());
		String[] canvasInputArray = "C 100".split(" ");
		canvasValidation.validate(canvasInputArray);
	}
	
	@Test
	public void testValidateWhenInputWidthIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.CANVAS_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] canvasInputArray = "C 100 pp".split(" ");
		canvasValidation.validate(canvasInputArray);
	}
	
	@Test
	public void testValidateWhenInputHeightIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.CANVAS_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] canvasInputArray = "C pp 100".split(" ");
		canvasValidation.validate(canvasInputArray);
	}
	
	@Test
	public void testValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		String[] canvasInputArray = "C 100 80".split(" ");
		assertTrue("Canvas validation should be successful.", canvasValidation.validate(canvasInputArray));
	}
	
	@Test
	public void testValidateWhenSecondCanvasIsCreatedThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.CANVAS_ALREADY_PRESENT.getMessage());
		CanvasService service = new CanvasService();
		service.createCanvas(20, 4);
		String[] canvasInputArray = "C 100 80".split(" ");
		canvasValidation.validate(canvasInputArray);
	}

}
