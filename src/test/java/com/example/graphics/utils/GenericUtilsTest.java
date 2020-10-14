package com.example.graphics.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.orchestrator.ShapeCreationOrchestrator;
import com.example.graphics.shape.service.impl.CanvasCreationService;

public class GenericUtilsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testIsValueLessThanOneWhenValueIsLessThanOneThenTrueShouldBeReturned() {
		Integer[] intValues = { 1, 2, -1, 0, 5 };
		GenericUtils.isValueLessThanOne(intValues);
	}

	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointIsInsideCanvasThenTrueShouldBeReturned() {
		if (CanvasCreationService.getCanvas() == null) {
			ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
			shapeCreationOrchestrator.createShape("C 20 4");
		}
		
		Point point = new Point(2, 2);
		assertTrue("Point is inside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(point));
	}
	
	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointIsOutsideCanvasThenFalseShouldBeReturned() {
		if (CanvasCreationService.getCanvas() == null) {
			ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
			shapeCreationOrchestrator.createShape("C 20 4");
		}
		
		Point point = new Point(21, 5);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(point));
	}
	
	@Test
	public void testCheckWhenTheCanvasIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationStatusCode.CANVAS_NOT_PRESENT.getMessage());
		CanvasCreationService.destroyCanvas();
		Point point = new Point(21, 5);
		GenericUtils.checkIfThePointIsInsideCanvas(point);
	}
}
