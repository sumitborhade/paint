package com.cs.paint.orchestrator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cs.paint.service.creator.impl.CanvasService;

public class ProcessOrchestratorTest {

	@Test
	public void testOrchestrateProcessWhenInputsAreCorrectTrueShouldBeReturned() {
		CanvasService.destroyCanvas();
		ProcessOrchestrator processOrchestrator = new ProcessOrchestrator();
		
		String[] inputs = {"C 20 4", "L 1 2 6 2", "L 6 3 6 4", "R 14 1 18 3", "B 10 3 o"};
		
		for (String inputString : inputs) {
			boolean isProcessCompleted = processOrchestrator.orchestrateProcess(inputString);
			assertTrue("Method should return true.", isProcessCompleted);
		}
	}

}
