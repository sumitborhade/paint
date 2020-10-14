package com.example.graphics.shape.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ExceptionCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.Shape;

public class LineCreationServiceTest {

	private Shape line;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		line = new LineCreationService();
	}

	@After
	public void tearDown() throws Exception {
		line = null;
	}

	@Test
	public void testCreateShapeWhenLinePointsAreInvalidThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ExceptionCode.INVALID_LINE_POINTS.getMessage());
		line.createShape("L 1 2 3 4".split(" "));
	}
	
	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		CanvasCreationService.destroyCanvas();
		Shape canvas = new CanvasCreationService();
		canvas.createShape("C 20 4".split(" "));
		assertTrue("Line should be created.", line.createShape("L 1 2 6 2".split(" ")));
	}

}
