package com.example.graphics.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.exception.CustomException;

public class BucketFillCreationServiceTest {

	private ShapeCreator bucketFill;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		bucketFill = new BucketFillCreationService();
	}

	@After
	public void tearDown() throws Exception {
		bucketFill = null;
	}

//	@Test
	public void testCreateShapeWhenLinePointsAreInvalidThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.INVALID_LINE_POINTS.getMessage());
		bucketFill.createShape("L 1 2 3 4".split(" "));
	}
	
//	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		CanvasService.destroyCanvas();
		ShapeCreator canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		assertTrue("Line should be created.", bucketFill.createShape("L 1 2 6 2".split(" ")));
	}

}
