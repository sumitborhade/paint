package com.cs.paint.creator.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cs.paint.service.ShapeService;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.service.creator.impl.RectangleService;

/**
 * Single Responsibility purpose: To test RectangleService.java
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class RectangleServiceTest {

	@Test
	public void testCreateShapeWhenLinePointsAreValidThenMethodShouldReturnTrue() {
		CanvasService.destroyCanvas();
		ShapeService canvas = new CanvasService();
		canvas.createShape("C 20 4".split(" "));
		ShapeService rectangle = new RectangleService();
		assertTrue("Rectangle should be created.", rectangle.createShape("R 14 1 18 3".split(" ")));
	}

}
