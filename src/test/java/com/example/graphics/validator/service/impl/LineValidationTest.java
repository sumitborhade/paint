package com.example.graphics.validator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.creator.service.impl.CanvasService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.orchestrator.ShapeCreationOrchestrator;
import com.example.graphics.validator.service.Validator;

public class LineValidationTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeCreator canvasCreator = new CanvasService();
		canvasCreator.createShape("C 20 4".split(" "));
	}

	@After
	public void tearDown() throws Exception {
		CanvasService.destroyCanvas();
	}
	
	@Test
	public void testLineValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.INCORRECT_LINE_INPUT_PARAMS.getMessage());
		String[] lineInputArray = "L 100".split(" ");
		Validator lineValidation = new LineValidation();
		lineValidation.validate(lineInputArray);
	}
	
	@Test
	public void testLineValidateWhenInputIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.LINE_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] lineInputArray = "L 100 pp 200 20".split(" ");
		Validator lineValidation = new LineValidation();
		lineValidation.validate(lineInputArray);
	}
	
	@Test
	public void testLineValidateWhenInputWidthOrHeightIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.LINE_COORDINATE_OUT_OF_CANVAS.getMessage());
		String[] lineInputArray = "L 0 0 200 20".split(" ");
		Validator lineValidation = new LineValidation();
		lineValidation.validate(lineInputArray);
	}
	
	@Test
	public void testLineValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		if (CanvasService.getCanvas() == null) {
			ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
			shapeCreationOrchestrator.createShape("C 20 4");
		}
		String[] lineInputArray = "L 2 2 8 2".split(" ");
		Validator lineValidation = new LineValidation();
		assertTrue("Line validation should be successful.", lineValidation.validate(lineInputArray));
	}

}
