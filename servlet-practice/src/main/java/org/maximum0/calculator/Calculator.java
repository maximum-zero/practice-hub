package org.maximum0.calculator;

import org.maximum0.calculator.domain.PositiveNumber;
import org.maximum0.calculator.operator.*;

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
