package com.cs.paint.orchestrator;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.orchestrator.ShapeValidatorOrchestrator;
import com.cs.paint.service.creator.impl.CanvasService;

public class ValidationOrchestratorTest {

	private ShapeValidatorOrchestrator validationOrchestrator;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		validationOrchestrator = new ShapeValidatorOrchestrator();
	}

	@After
	public void tearDown() throws Exception {
		validationOrchestrator = null;
	}

	@Test
	public void testTriggerValidationWhenInputIsNullThenExceptionShouldBeThrown() {
		String inputString = null;
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.NULL_INPUT.getMessage());
		validationOrchestrator.performValidation(inputString);
	}
	
	@Test
	public void testTriggerValidationWhenInputIsIncorrectThenExceptionShouldBeThrown() {
		String inputString = "P 1 2";
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_DESIGN_TYPE.getMessage());
		validationOrchestrator.performValidation(inputString);
	}
	
	@Test
	public void testTriggerValidationWhenInputIsCorrectForCanvasThenValidationShouldBeSuccessfully() {
		String inputString = "C 100 80";
		CanvasService.destroyCanvas();
		assertTrue(validationOrchestrator.performValidation(inputString));
	}

}
