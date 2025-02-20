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
import com.cs.paint.service.validator.impl.BucketFillValidator;

/**
 * Single Responsibility purpose: To test BucketFillValidator.java 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class BucketFillValidatorTest {

	private ValidatorService bucketValidation;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeService canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		bucketValidation = new BucketFillValidator();
	}

	@After
	public void tearDown() throws Exception {
		bucketValidation = null;
	}

	@Test
	public void testBucketValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_BUCKET_FILL_INPUT_PARAMS.getMessage());
		String[] bucketInputArray = "B 100".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputWidthIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.BUCKET_FILL_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] bucketInputArray = "B 100 pp C".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputHeightIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.BUCKET_FILL_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] bucketInputArray = "B pp 100 C".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenBucketFillPointIsNotInCanavsThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.BUCKET_FILL_COORDINATE_OUT_OF_CANVAS.getMessage());
		String[] bucketInputArray = "B 24 1 C".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		String[] bucketInputArray = "B 14 1 C".split(" ");
		assertTrue("Bucket validation should be successful.", bucketValidation.validate(bucketInputArray));
	}

}
