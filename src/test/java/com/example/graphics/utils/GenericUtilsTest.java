package com.example.graphics.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.impl.CanvasService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.orchestrator.ShapeCreationOrchestrator;

public class GenericUtilsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testIsValueLessThanOneWhenValueIsLessThanOneThenTrueShouldBeReturned() {
		Integer[] intValues = { 1, 2, -1, 0, 5 };
		assertTrue("Method isValueLessThanOne() should return true.", GenericUtils.isValueLessThanOne(intValues));
	}

	@Test
	public void testIsValueGreaterThanOneWhenValueIsLessThanOneThenFalseShouldBeReturned() {
		Integer[] intValues = { 1, 2, 3, 4 };
		assertFalse("Method isValueLessThanOne() should return true.", GenericUtils.isValueLessThanOne(intValues));
	}

	@Test
	public void testIsIntegerWhenInputArrayIsNullThenFalseShouldBeReturned() {
		String[] incorrectValue = null;
		assertFalse("Method isInteger() should return false.", GenericUtils.isInteger(incorrectValue));
	}

	@Test
	public void testIsIntegerWhenInputStringIsNullThenFalseShouldBeReturned() {
		String incorrectValue = null;
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.NULL_INPUT.getMessage());
		GenericUtils.isInteger(incorrectValue);
	}

	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointIsInsideCanvasThenTrueShouldBeReturned() {
		CanvasService.destroyCanvas();
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		shapeCreationOrchestrator.createShape("C 20 4");

		Point point = new Point(2, 2);
		assertTrue("Point is inside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(point));
	}

	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointIsOutsideCanvasThenFalseShouldBeReturned() {
		CanvasService.destroyCanvas();
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		shapeCreationOrchestrator.createShape("C 20 4");

		Point point = new Point(21, 5);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(point));
	}

	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointsAreOutsideCanvasThenFalseShouldBeReturned() {
		CanvasService.destroyCanvas();
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		shapeCreationOrchestrator.createShape("C 20 4");

		Point pointOne = new Point(0, 2);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointOne));
		Point pointTwo = new Point(2, 0);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointTwo));
		Point pointThree = new Point(100, 2);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointThree));
		Point pointFour = new Point(2, 100);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointFour));
	}

	@Test
	public void testCheckWhenTheCanvasIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.CANVAS_NOT_PRESENT.getMessage());
		CanvasService.destroyCanvas();
		Point point = new Point(21, 5);
		GenericUtils.checkIfThePointIsInsideCanvas(point);
	}
}
