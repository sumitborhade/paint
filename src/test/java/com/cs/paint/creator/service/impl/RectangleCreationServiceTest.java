package com.cs.paint.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cs.paint.creator.service.ShapeCreator;
import com.cs.paint.creator.service.impl.CanvasService;
import com.cs.paint.creator.service.impl.RectangleCreationService;

public class RectangleCreationServiceTest {

	private ShapeCreator rectangle;
	
	@Before
	public void setUp() throws Exception {
		CanvasService.destroyCanvas();
		ShapeCreator canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		rectangle = new RectangleCreationService();
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
