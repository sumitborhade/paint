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
import com.cs.paint.service.validator.impl.LineValidator;

/**
 * Single Responsibility purpose: To test LineValidator.java 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class LineValidatorTest {

	private ValidatorService lineValidator;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeService canvasCreator = new CanvasService();
		canvasCreator.createShape("C 20 4".split(" "));
		lineValidator = new LineValidator();
	}

	@After
	public void tearDown() throws Exception {
		lineValidator  = null;
	}
	
	@Test
	public void testLineValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_LINE_INPUT_PARAMS.getMessage());
		String[] lineInputArray = "L 100".split(" ");
		lineValidator.validate(lineInputArray);
	}
	
	@Test
	public void testLineValidateWhenInputIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.LINE_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] lineInputArray = "L 100 pp 200 20".split(" ");
		lineValidator.validate(lineInputArray);
	}
	
	@Test
	public void testLineValidateWhenInputWidthOrHeightIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.LINE_COORDINATE_OUT_OF_CANVAS.getMessage());
		String[] lineInputArray = "L 0 0 200 20".split(" ");
		lineValidator.validate(lineInputArray);
	}
	
	@Test
	public void testLineValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		String[] lineInputArray = "L 2 2 8 2".split(" ");
		assertTrue("Line validation should be successful.", lineValidator.validate(lineInputArray));
	}

}
