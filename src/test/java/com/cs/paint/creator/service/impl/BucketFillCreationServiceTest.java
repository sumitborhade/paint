package com.cs.paint.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.creator.service.ShapeService;
import com.cs.paint.creator.service.impl.BucketFillService;
import com.cs.paint.creator.service.impl.CanvasService;

public class BucketFillCreationServiceTest {

	private ShapeService bucketFill;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeService canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		bucketFill = new BucketFillService();
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
