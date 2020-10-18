package com.cs.paint.factory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeValidatorFactory;

/**
 * Single Responsibility purpose: To test ShapeValidatorFactory.java
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class ShapeValidatorFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testGetValidationEntityWhenInputTypeIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.NULL_INPUT.getMessage());
		ShapeValidatorFactory.getValidatorEntity(null);
	}

}
