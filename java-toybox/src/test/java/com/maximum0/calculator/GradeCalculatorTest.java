package com.maximum0.calculator;

import com.maximum0.calculator.domain.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GradeCalculatorTest {

    @DisplayName("평균 학점을 계산합니다.")
    @Test
    void calculateTest() {
        GradeCalculator gradeCalculator = new GradeCalculator(List.of(new Course("OOP", 3, "A"), new Course("자료구조", 5, "A")));
        double result = gradeCalculator.calculator();
        assertThat(result).isEqualTo(4);
    }
}
