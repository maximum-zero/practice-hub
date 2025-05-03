package com.maximum0.calculator;

import com.maximum0.calculator.domain.Course;
import com.maximum0.calculator.domain.Courses;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculator() {
        // 평균 학점 계산 = (학점수 x 교과목 평점)의 합계 / 수강신청 총 학점 수
        return courses.multiplyCreditAndCourseGrade() / courses.calculateTotalCompletedCredit();
    }
}
