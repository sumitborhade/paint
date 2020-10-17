package com.cs.paint.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cs.paint.service.ShapeService;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.service.creator.impl.RectangleService;

public class RectangleCreationServiceTest {

	private ShapeService rectangle;
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeService canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		rectangle = new RectangleService();
	}

	@After
	public void tearDown() throws Exception {
		rectangle = null;
	}

	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		assertTrue("Rectangle should be created.", rectangle.createShape("R 14 1 18 3".split(" ")));
	}

}
