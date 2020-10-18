package com.cs.paint.creator.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.creator.impl.CanvasService;

/**
 * Single Responsibility purpose: To test the CanvasService.java 
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class CanvasServiceTest {

	private CanvasService canvasService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		canvasService = new CanvasService();
	}

	@After
	public void tearDown() throws Exception {
		canvasService = null;
	}

	@Test
	public void testCreateCanvasWhenIncorrectWidthIsPassedThenCanvasShouldNotBeCreated() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_CANVAS_INPUT_VALUE.getMessage());
		canvasService.createCanvas(0, 4);
	}

	@Test
	public void testCreateCanvasWhenIncorrectHeightIsPassedThenCanvasShouldNotBeCreated() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_CANVAS_INPUT_VALUE.getMessage());
		canvasService.createCanvas(10, 0);
	}

	@Test
	public void testCreateCanvasWhenWidthAndHeightAreZeroThenCanvasShouldNotBeCreated() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_CANVAS_INPUT_VALUE.getMessage());
		canvasService.createCanvas(0, 0);
	}

	@Test
	public void testCreateCanvasWhenInputIsCorrectThenCanvasShouldBeCreated() {
		canvasService.createCanvas(20, 4);
		assertNotNull("Canvas should be created and hence will not be null.", CanvasService.getCanvas());
		assertEquals("After adding the right & left columns width should be 22.", 22, CanvasService.getCanvas().length);
		assertTrue("Canvas should not throw any exception.", CanvasService.printCanvas());
	}

	@Test
	public void testCreateCanvasWhenSecondCanvasIsTriedToBeCreatedThenSecondCanvasShouldNotBeCreated() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.CANVAS_ALREADY_PRESENT.getMessage());
		canvasService.createCanvas(20, 4);
		canvasService.createCanvas(20, 6);
	}

}
