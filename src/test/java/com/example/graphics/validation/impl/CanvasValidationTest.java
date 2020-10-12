package com.example.graphics.validation.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.impl.CanvasCreationService;
import com.example.graphics.validation.Validation;

public class CanvasValidationTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.INCORRECT_CANVAS_INPUT_PARAMS.getMessage());
		String[] canvasInputArray = "C 100".split(" ");
		CanvasCreationService.destroyCanvas();
		Validation canvasValidation = new CanvasValidation();
		canvasValidation.validate(canvasInputArray);
	}
	
	@Test
	public void testValidateWhenInputWidthIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.CANVAS_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] canvasInputArray = "C 100 pp".split(" ");
		CanvasCreationService.destroyCanvas();
		Validation canvasValidation = new CanvasValidation();
		canvasValidation.validate(canvasInputArray);
	}
	
	@Test
	public void testValidateWhenInputHeightIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.CANVAS_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] canvasInputArray = "C pp 100".split(" ");
		CanvasCreationService.destroyCanvas();
		Validation canvasValidation = new CanvasValidation();
		canvasValidation.validate(canvasInputArray);
	}
	
	@Test
	public void testValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		String[] canvasInputArray = "C 100 80".split(" ");
		CanvasCreationService.destroyCanvas();
		Validation canvasValidation = new CanvasValidation();
		assertTrue("Canvas validation should be successful.", canvasValidation.validate(canvasInputArray));
	}
	
	@Test
	public void testValidateWhenSecondCanvasIsCreatedThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.CANVAS_ALREADY_PRESENT.getMessage());
		
		String[] canvasInputArray = "C 100 80".split(" ");
		CanvasCreationService service = new CanvasCreationService();
		service.createCanvas(20, 4);
		Validation canvasValidation = new CanvasValidation();
		canvasValidation.validate(canvasInputArray);
	}

}
