package com.maximum0.calculator;

import com.maximum0.calculator.domain.PositiveNumber;
import com.maximum0.calculator.operator.AdditionArithmeticOperator;
import com.maximum0.calculator.operator.DivisionArithmeticOperator;
import com.maximum0.calculator.operator.IArithmeticOperator;
import com.maximum0.calculator.operator.MultiplicationArithmeticOperator;
import com.maximum0.calculator.operator.SubtractionArithmeticOperator;

import java.util.List;

public class Calculator {

    private static List<IArithmeticOperator> arithmeticOperators = List.of(
        new AdditionArithmeticOperator(), new SubtractionArithmeticOperator(), new MultiplicationArithmeticOperator(), new DivisionArithmeticOperator()
    );

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperators.stream()
            .filter((arithmeticOperator) -> arithmeticOperator.support(operator))
            .map((arithmeticOperator) -> arithmeticOperator.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(() -> new ArithmeticException("올바른 사칙 연산이 아닙니다."));
    }
}
