package com.example.graphics.validator.service.impl;

import java.util.Arrays;
import java.util.stream.Stream;

import com.example.graphics.constants.ApplicationWarningCode;
import com.example.graphics.creator.service.impl.CanvasCreationService;
import com.example.graphics.exception.CustomException;
import com.example.graphics.model.Point;
import com.example.graphics.utils.GenericUtils;
import com.example.graphics.validator.service.Validator;

public class RectangleValidation implements Validator {

	@Override
	public boolean validate(String[] inputArray) {
		validateIfNumberOfParamsAreCorrect(inputArray);
		validateIfThePointsAreInteger(inputArray);
		
		Point startPoint = new Point(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
		Point endPoint = new Point(Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]));
		GenericUtils.checkIfThePointIsInsideCanvas(startPoint, endPoint);
		
		int[] dimensions = Stream.of(Arrays.copyOfRange(inputArray, 1, inputArray.length)).mapToInt(Integer::parseInt)
				.toArray();
		validateIfRectangleIsWithinCanvas(dimensions);

		return true;
	}
	
	private void validateIfNumberOfParamsAreCorrect(String[] inputArray) {
		if (inputArray.length != 5) {
			throw new CustomException(ApplicationWarningCode.INCORRECT_RECTANGLE_INPUT_PARAMS);
		}
	}

	private void validateIfThePointsAreInteger(String[] inputArray) {
		if (!GenericUtils.isInteger(inputArray[1], inputArray[2], inputArray[3], inputArray[4])) {
			throw new CustomException(ApplicationWarningCode.RECTANGLE_INPUT_SHOULD_BE_INTEGER);
		}
	}

	private boolean validateIfRectangleIsWithinCanvas(int[] dimensions) {
		String[][] canvas = CanvasCreationService.getCanvas();
		int canvasWidth = canvas.length - 2;
		int canvasHeight = canvas[0].length - 2;

		if (dimensions[0] > canvasWidth || dimensions[2] > canvasWidth || dimensions[1] > canvasHeight
				|| dimensions[3] > canvasHeight) {
			throw new CustomException(ApplicationWarningCode.RECTANGLE_CO_ORDS_OUT_OF_CANVAS);
		}

		return true;
	}
}