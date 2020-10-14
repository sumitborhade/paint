package com.example.graphics.orchestrator;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.graphics.constants.ApplicationStatusCode;
import com.example.graphics.exception.CustomException;
import com.example.graphics.shape.service.impl.CanvasCreationService;

public class ShapeCreationOrchestratorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCreateShapeWhenInputAsCanvasThenCanvasShouldBeCreated() {
		if (CanvasCreationService.getCanvas() == null) {
			ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
			shapeCreationOrchestrator.createShape("C 20 4");
		}

		assertNotNull(CanvasCreationService.getCanvas());
	}

	@Test
	public void testCreateShapeWhenInputIncorrectDesignTypeThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationStatusCode.INCORRECT_DESIGN_TYPE.getMessage());
		CanvasCreationService.destroyCanvas();
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		shapeCreationOrchestrator.createShape("X 20 4");

		assertNotNull(CanvasCreationService.getCanvas());
	}
	
	@Test
	public void testCreateShapeWhenInputNullDesignTypeThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationStatusCode.NULL_INPUT.getMessage());
		CanvasCreationService.destroyCanvas();
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		shapeCreationOrchestrator.createShape(null);
		
		assertNotNull(CanvasCreationService.getCanvas());
	}

}
