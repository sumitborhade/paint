package com.cs.paint.factory;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.factory.ShapeCreatorFactory;
import com.cs.paint.service.ShapeService;
import com.cs.paint.service.creator.impl.CanvasService;

/**
 * Single Responsibility purpose: To test ShapeCreatorFactory.java
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class ShapeCreatorFactoryTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testGetShapeEntityWhenInputTypeIsNullThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.NULL_INPUT.getMessage());
		ShapeCreatorFactory.getShapeCreatorEntity(null);
	}
	
	@Test
	public void testGetShapeEntityWhenInputTypeIsCThenCanvasShouldBeReturned() {
		ShapeService canvasShape = ShapeCreatorFactory.getShapeCreatorEntity("c");
		assertTrue("In this test, shape should be of type canvas", canvasShape instanceof CanvasService);
	}

}
