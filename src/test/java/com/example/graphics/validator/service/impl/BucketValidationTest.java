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
import com.example.graphics.validator.service.Validator;
import com.example.graphics.validator.service.impl.BucketFillValidation;

public class BucketValidationTest {

	private Validator bucketValidation;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeCreator canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		bucketValidation = new BucketFillValidation();
	}

	@After
	public void tearDown() throws Exception {
		bucketValidation = null;
	}

	@Test
	public void testBucketValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.INCORRECT_BUCKET_FILL_INPUT_PARAMS.getMessage());
		String[] bucketInputArray = "B 100".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputWidthIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.BUCKET_FILL_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] bucketInputArray = "B 100 pp C".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputHeightIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.BUCKET_FILL_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] bucketInputArray = "B pp 100 C".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		String[] bucketInputArray = "B 14 1 C".split(" ");
		assertTrue("Bucket validation should be successful.", bucketValidation.validate(bucketInputArray));
	}

}
