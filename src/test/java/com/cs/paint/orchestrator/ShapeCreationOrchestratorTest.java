package com.cs.paint.orchestrator;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cs.paint.constants.ApplicationWarningCode;
import com.cs.paint.exception.CustomException;
import com.cs.paint.orchestrator.ShapeCreationOrchestrator;
import com.cs.paint.service.creator.impl.CanvasService;

public class ShapeCreationOrchestratorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCreateShapeWhenInputAsCanvasThenCanvasShouldBeCreated() {
		if (CanvasService.getCanvas() == null) {
			ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
			shapeCreationOrchestrator.createShape("C 20 4");
		}

		assertNotNull(CanvasService.getCanvas());
	}

	@Test
	public void testCreateShapeWhenInputIncorrectDesignTypeThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.INCORRECT_DESIGN_TYPE.getMessage());
		CanvasService.destroyCanvas();
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		shapeCreationOrchestrator.createShape("X 20 4");

		assertNotNull(CanvasService.getCanvas());
	}
	
	@Test
	public void testCreateShapeWhenInputNullDesignTypeThenExceptionShouldBeThrown() {
		thrown.expect(CustomException.class);
		thrown.expectMessage(ApplicationWarningCode.NULL_INPUT.getMessage());
		CanvasService.destroyCanvas();
		ShapeCreationOrchestrator shapeCreationOrchestrator = new ShapeCreationOrchestrator();
		shapeCreationOrchestrator.createShape(null);
		
		assertNotNull(CanvasService.getCanvas());
	}

}
