package com.example.graphics.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.impl.CanvasCreationService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CanvasServiceImplTest {
	
	@Test
	public void testAConstructorWhenIncorrectWidthIsPassedThenCanvasShouldNotBeCreated() {
		try {
			if (CanvasCreationService.getCanvas() == null) {
				CanvasCreationService canvasCreationService = new CanvasCreationService();
				canvasCreationService.createCanvas(0, 4);
			}
		} catch (CustomException e) {
			assertEquals(ExceptionCode.INCORRECT_CANVAS_INPUT_VALUE.getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testBConstructorWhenIncorrectHeightIsPassedThenCanvasShouldNotBeCreated() {
		try {
			if (CanvasCreationService.getCanvas() == null) {
				CanvasCreationService canvasCreationService = new CanvasCreationService();
				canvasCreationService.createCanvas(10, 0);
			}
		} catch (CustomException e) {
			assertEquals(ExceptionCode.INCORRECT_CANVAS_INPUT_VALUE.getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testCConstructorWhenIncorrectHeightIsPassedThenCanvasShouldNotBeCreated() {
		try {
			CanvasCreationService.destroyCanvas();
			CanvasCreationService canvasCreationService = new CanvasCreationService();
			canvasCreationService.createCanvas(10, 0);
		} catch (CustomException e) {
			assertEquals(ExceptionCode.INCORRECT_CANVAS_INPUT_VALUE.getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testDConstructorWhenWidthAndHeightAreZeroThenCanvasShouldNotBeCreated() {
		try {
			CanvasCreationService.destroyCanvas();
			CanvasCreationService canvasCreationService = new CanvasCreationService();
			canvasCreationService.createCanvas(0, 0);
		} catch (CustomException e) {
			assertEquals(ExceptionCode.INCORRECT_CANVAS_INPUT_VALUE.getMessage(), e.getMessage());
		}
	}
	
	@Test
	public void testPConstructorWhenInputIsCorrectThenCanvasShouldBeCreated() {
		if (CanvasCreationService.getCanvas() == null) {
			CanvasCreationService canvasCreationService = new CanvasCreationService();
			canvasCreationService.createCanvas(20, 4);
		}
		assertNotNull("Canvas should be created and hence will not be null.",CanvasCreationService.getCanvas());
		assertEquals("After adding the right & left columns width should be 22.", 22, CanvasCreationService.getCanvas().length);
		assertTrue("Canvas should not throw any exception.", CanvasCreationService.printCanvas());
	}
	
	@Test
	public void testQConstructorWhenSecondCanvasIsTriedToBeCreatedThenSecondCanvasShouldNotBeCreated() {
		try {
			CanvasCreationService canvasCreationService = new CanvasCreationService();
			canvasCreationService.createCanvas(20, 4);
		} catch (CustomException e) {
			assertEquals(ExceptionCode.CANVAS_ALREADY_PRESENT.getMessage(), e.getMessage());
		}
	}
	
}
