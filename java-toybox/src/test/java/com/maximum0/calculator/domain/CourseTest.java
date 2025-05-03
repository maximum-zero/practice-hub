package com.maximum0.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CourseTest {

    @DisplayName("과목을 생성합니다.")
    @Test
    void createCourse() {
        assertThatCode(() -> new Course("OOP", 3, "A+"))
            .doesNotThrowAnyException();
    }

    @DisplayName("학점을 숫자로 변경합니다.")
    @ParameterizedTest
    @MethodSource("gradeAndNumberGrade")
    void validGradeRange(String grade, double result) {
        Course course = new Course("과목1", 1, grade);
        double resultGrade = course.getGradeToNumber();
        assertThat(resultGrade).isEqualTo(result);
    }

    @DisplayName("학점의 문자가 유효하지 않으면 IllegalArgumentException 예외를 발생시킵니다.")
    @Test
    void exceptionByNotValidGradeRange() {
        assertThatCode(() -> {
            Course course = new Course("과목1", 1, "Z");
            course.getGradeToNumber();
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("유효하지 않은 점수입니다.");
    }

    private static Stream<Arguments> gradeAndNumberGrade() {
        return Stream.of(
            arguments("A+", 4.5),
            arguments("A", 4.0),
            arguments("B+", 3.5),
            arguments("B", 3.0),
            arguments("C", 2.0),
            arguments("D", 1.0),
            arguments("F", 0.0)
        );
    }
}
