package com.example.graphics.validation.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.validation.Validation;

public class RectangleValidationTest {

	private Validation rectangleValidation;
	
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
		thrown.expectMessage(ExceptionCode.INCORRECT_RECTANGLE_INPUT_PARAMS.getMessage());
		String[] rectangleInputArray = "L 100".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenInputIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.RECTANGLE_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] rectangleInputArray = "L 100 pp 200 20".split(" ");
		rectangleValidation.validate(rectangleInputArray);
	}
	
	@Test
	public void testRectangleValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		String[] rectangleInputArray = "L 100 80 200 80".split(" ");
		assertTrue("Rectangle validation should be successful.", rectangleValidation.validate(rectangleInputArray));
	}

}
