package com.cs.paint.factory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ValidationFactory;

public class ValidationFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testGetValidationEntityWhenInputTypeIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.NULL_INPUT.getMessage());
		ValidationFactory.getValidationEntity(null);
	}

}
