package com.cs.paint.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.creator.service.ShapeService;
import com.cs.paint.creator.service.impl.CanvasService;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeCreatorFactory;

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
		ShapeService canvasShape = ShapeCreatorFactory.getShapeEntity("c");
		assertTrue("In this test, shape should be of type canvas", canvasShape instanceof CanvasService);
	}

}
