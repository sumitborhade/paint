package com.example.graphics.shape.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.creator.service.impl.RectangleCreationService;

public class RectangleCreationServiceTest {

	private ShapeCreator rectangle;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		rectangle = new RectangleCreationService();
	}

	@After
	public void tearDown() throws Exception {
		rectangle = null;
	}

	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		CanvasCreationService.destroyCanvas();
		ShapeCreator canvas = new CanvasCreationService();
		canvas.createShape("C 20 4".split(" "));
		assertTrue("Rectangle should be created.", rectangle.createShape("R 14 1 18 3".split(" ")));
	}

}
