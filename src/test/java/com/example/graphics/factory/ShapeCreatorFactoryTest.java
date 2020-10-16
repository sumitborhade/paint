package com.example.graphics.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.ShapeCreator;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.exception.CustomException;

public class ShapeCreatorFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testGetShapeEntityWhenInputTypeIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.NULL_INPUT.getMessage());
		ShapeCreatorFactory.getShapeEntity(null);
	}
	
	@Test
	public void testGetShapeEntityWhenInputTypeIsCThenCanvasShouldBeReturned() {
		ShapeCreator canvasShape = ShapeCreatorFactory.getShapeEntity("c");
		assertTrue("In this test, shape should be of type canvas", canvasShape instanceof CanvasCreationService);
	}

}
