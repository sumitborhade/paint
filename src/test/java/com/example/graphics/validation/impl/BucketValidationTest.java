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

public class BucketValidationTest {

	private Validation bucketValidation;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		bucketValidation = new BucketValidation();
	}

	@After
	public void tearDown() throws Exception {
		bucketValidation = null;
	}

	@Test
	public void testBucketValidateWhenInputIsWithIncorrectNumberOfParametersThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.INCORRECT_BUCKET_INPUT_PARAMS.getMessage());
		String[] bucketInputArray = "B 100".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputWidthIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.BUCKET_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] bucketInputArray = "B 100 pp C".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputHeightIsIncorrectThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.BUCKET_INPUT_SHOULD_BE_INTEGER.getMessage());
		String[] bucketInputArray = "B pp 100 C".split(" ");
		bucketValidation.validate(bucketInputArray);
	}
	
	@Test
	public void testBucketValidateWhenInputIsCorrectThenValidationShouldBeSucessful() {
		String[] bucketInputArray = "B 100 80 C".split(" ");
		assertTrue("Bucket validation should be successful.", bucketValidation.validate(bucketInputArray));
	}

}
