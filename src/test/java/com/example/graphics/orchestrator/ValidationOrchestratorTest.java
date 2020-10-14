package com.example.graphics.orchestrator;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.impl.CanvasCreationService;

public class ValidationOrchestratorTest {

	private ValidationOrchestrator validationOrchestrator;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		validationOrchestrator = new ValidationOrchestrator();
	}

	@After
	public void tearDown() throws Exception {
		validationOrchestrator = null;
	}

	@Test
	public void testTriggerValidationWhenInputIsNullThenExceptionShouldBeThrown() {
		String inputString = null;
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationStatusCode.NULL_INPUT.getMessage());
		validationOrchestrator.performValidation(inputString);
	}
	
	@Test
	public void testTriggerValidationWhenInputIsIncorrectThenExceptionShouldBeThrown() {
		String inputString = "P 1 2";
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationStatusCode.INCORRECT_DESIGN_TYPE.getMessage());
		validationOrchestrator.performValidation(inputString);
	}
	
	@Test
	public void testTriggerValidationWhenInputIsCorrectForCanvasThenValidationShouldBeSuccessfully() {
		String inputString = "C 100 80";
		CanvasCreationService.destroyCanvas();
		assertTrue(validationOrchestrator.performValidation(inputString));
	}

}
