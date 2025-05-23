package com.maximum0.calculator.domain;

public class Course {
    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public double multiplyCreditAndGrade() {
        return this.credit * getGradeToNumber();
    }

    public int getCredit() {
        return this.credit;
    }

    public double getGradeToNumber() {
        switch (grade) {
            case "A+": return 4.5;
            case "A": return 4.0;
            case "B+": return 3.5;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: throw new IllegalArgumentException("유효하지 않은 점수입니다.");
        }
    }
}
