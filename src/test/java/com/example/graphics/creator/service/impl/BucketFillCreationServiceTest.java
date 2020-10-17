package com.example.graphics.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.creator.service.ShapeCreator;

public class BucketFillCreationServiceTest {

	private ShapeCreator bucketFill;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeCreator canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		bucketFill = new BucketFillCreationService();
	}

	@After
	public void tearDown() throws Exception {
		bucketFill = null;
	}

	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		assertTrue("Bucket fill should be performed.", bucketFill.createShape("B 1 2 c".split(" ")));
	}

}
