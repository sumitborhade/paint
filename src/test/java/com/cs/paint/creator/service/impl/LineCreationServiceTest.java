package com.cs.paint.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.service.ShapeService;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.service.creator.impl.LineService;

public class LineCreationServiceTest {

	private ShapeService line;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeService canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		line = new LineService();
	}

	@After
	public void tearDown() throws Exception {
		line = null;
	}

	@Test
	public void testCreateShapeWhenLinePointsAreInvalidThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INVALID_LINE_POINTS.getMessage());
		line.createShape("L 1 2 3 4".split(" "));
	}
	
	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		assertTrue("Line should be created.", line.createShape("L 1 2 6 2".split(" ")));
	}

}
