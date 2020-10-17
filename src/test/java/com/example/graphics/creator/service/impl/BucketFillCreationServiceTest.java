package com.example.graphics.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.creator.service.impl.LineCreationService;
import com.example.graphics.exception.CustomException;

public class BucketFillCreationServiceTest {

	private ShapeCreator line;
	
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
		thrown.expectMessage(ApplicationWarningCode.INVALID_LINE_POINTS.getMessage());
		line.createShape("L 1 2 3 4".split(" "));
	}
	
	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		CanvasCreationService.destroyCanvas();
		ShapeCreator canvas = new CanvasCreationService();
		canvas.createShape("C 20 4".split(" "));
		assertTrue("Line should be created.", line.createShape("L 1 2 6 2".split(" ")));
	}

}
