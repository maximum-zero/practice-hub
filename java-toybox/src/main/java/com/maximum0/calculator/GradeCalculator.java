package com.maximum0.calculator;

import com.maximum0.calculator.domain.Course;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculator() {
        double total = 0.0;
        int count = 0;
        for (Course course : courses) {
            total += course.multiplyCreditAndGrade();
            count += course.getCredit();
        }
        return total / count;
    }
}
