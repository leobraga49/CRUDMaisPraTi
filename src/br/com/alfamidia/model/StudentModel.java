package br.com.alfamidia.model;

import java.time.LocalDate;

public class Student extends Person{
    private float finalGrade = 0;

    public Student() {
    }

    public Student(String name, String phone, String birthDate, LocalDate registrationDate, LocalDate changeDate, float finalGrade) {
        super(name, phone, birthDate, registrationDate, changeDate);
        this.finalGrade = finalGrade;
    }

    public float getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(float finalGrade) {
        this.finalGrade = finalGrade;
    }
}
