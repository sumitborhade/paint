package com.cs.paint.orchestrator;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.exception.ApplicationExceptionCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.orchestrator.ShapeCreatorOrchestrator;
import com.cs.paint.service.creator.impl.CanvasService;

/**
 * Single Responsibility purpose: To test ShapeCreatorOrchestrator.java
 * 
 * @author Sumit Borhade (borhadesumit58@gmail.com)
 * 
 */
public class ShapeCreatorOrchestratorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCreateShapeWhenInputAsCanvasThenCanvasShouldBeCreated() {
		if (CanvasService.getCanvas() == null) {
			ShapeCreatorOrchestrator shapeCreationOrchestrator = new ShapeCreatorOrchestrator();
			shapeCreationOrchestrator.createShape("C 20 4");
		}

		assertNotNull(CanvasService.getCanvas());
	}

	@Test
	public void testCreateShapeWhenInputIncorrectDesignTypeThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.INCORRECT_DESIGN_TYPE.getMessage());
		CanvasService.destroyCanvas();
		ShapeCreatorOrchestrator shapeCreationOrchestrator = new ShapeCreatorOrchestrator();
		shapeCreationOrchestrator.createShape("X 20 4");

		assertNotNull(CanvasService.getCanvas());
	}
	
	@Test
	public void testCreateShapeWhenInputNullDesignTypeThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationExceptionCode.NULL_INPUT.getMessage());
		CanvasService.destroyCanvas();
		ShapeCreatorOrchestrator shapeCreationOrchestrator = new ShapeCreatorOrchestrator();
		shapeCreationOrchestrator.createShape(null);
		
		assertNotNull(CanvasService.getCanvas());
	}

}
