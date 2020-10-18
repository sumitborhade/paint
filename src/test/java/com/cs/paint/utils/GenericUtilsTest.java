package com.cs.paint.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.model.PointModel;
import com.cs.paint.orchestrator.ShapeCreatorOrchestrator;
import com.cs.paint.service.creator.impl.CanvasService;
import com.cs.paint.utils.GenericUtils;

/**
 * Single Responsibility purpose: To test GenericUtils.java
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
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
		thrown.expectMessage(ApplicationExceptionCode.NULL_INPUT.getMessage());
		GenericUtils.isInteger(incorrectValue);
	}

	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointIsInsideCanvasThenTrueShouldBeReturned() {
		CanvasService.destroyCanvas();
		ShapeCreatorOrchestrator shapeCreationOrchestrator = new ShapeCreatorOrchestrator();
		shapeCreationOrchestrator.createShape("C 20 4");

		PointModel point = new PointModel(2, 2);
		assertTrue("Point is inside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(point));
	}

	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointIsOutsideCanvasThenFalseShouldBeReturned() {
		CanvasService.destroyCanvas();
		ShapeCreatorOrchestrator shapeCreationOrchestrator = new ShapeCreatorOrchestrator();
		shapeCreationOrchestrator.createShape("C 20 4");

		PointModel point = new PointModel(21, 5);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(point));
	}

	@Test
	public void testCheckWhenThePointIsInsideCanvasThenPointsAreOutsideCanvasThenFalseShouldBeReturned() {
		CanvasService.destroyCanvas();
		ShapeCreatorOrchestrator shapeCreationOrchestrator = new ShapeCreatorOrchestrator();
		shapeCreationOrchestrator.createShape("C 20 4");

		PointModel pointOne = new PointModel(0, 2);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointOne));
		PointModel pointTwo = new PointModel(2, 0);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointTwo));
		PointModel pointThree = new PointModel(100, 2);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointThree));
		PointModel pointFour = new PointModel(2, 100);
		assertFalse("Point is outside the canvas", GenericUtils.checkIfThePointIsInsideCanvas(pointFour));
	}

	@Test
	public void testCheckWhenTheCanvasIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.CANVAS_NOT_PRESENT.getMessage());
		CanvasService.destroyCanvas();
		PointModel point = new PointModel(21, 5);
		GenericUtils.checkIfThePointIsInsideCanvas(point);
	}
}
