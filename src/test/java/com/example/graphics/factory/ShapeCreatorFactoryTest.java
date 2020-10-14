package com.example.graphics.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.Shape;
import com.example.graphics.shape.service.impl.CanvasCreationService;

public class ShapeCreatorFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testGetShapeEntityWhenInputTypeIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationStatusCode.NULL_INPUT.getMessage());
		ShapeCreatorFactory.getShapeEntity(null);
	}
	
	@Test
	public void testGetShapeEntityWhenInputTypeIsCThenCanvasShouldBeReturned() {
		Shape canvasShape = ShapeCreatorFactory.getShapeEntity("c");
		assertTrue("In this test, shape should be of type canvas", canvasShape instanceof CanvasCreationService);
	}

}
