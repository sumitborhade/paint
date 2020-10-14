package com.example.graphics.factory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;

public class ValidationFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testGetValidationEntityWhenInputTypeIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationStatusCode.NULL_INPUT.getMessage());
		ValidationFactory.getValidationEntity(null);
	}

}
