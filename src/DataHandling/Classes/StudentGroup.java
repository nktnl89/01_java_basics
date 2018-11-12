package DataHandling.Classes;

import DataHandling.Interfaces.StudentGroupInterface;

import java.util.ArrayList;
import java.util.Collections;

public class StudentGroup implements StudentGroupInterface {
    private ArrayList<Student> students;

    public StudentGroup(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentGroup() {
    }

    public ArrayList<Student> getStudents() {

        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public void showListResult(Student... studentsList) {
        for (Student student : studentsList) {
            System.out.println(student.getName() + " - " +
                    "До окончания обучения по программе " + student.getCurriculum().getName() + " осталось " +
                    student.getRemainingTime() + " ч. " +
                    "Средний бал " + student.getAverageMark() +
                    (student.getSentence() ? " Может продолжить обучение." : " Отчислить."));
        }
    }

    @Override
    public void showListResultSortAverage() {
        //comparator
        //Collections.sort(students,);
        //showListResult
    }

    @Override
    public void showListResultSortTimeRemaining() {

    }

    @Override
    public void showListResultSortSentence() {

    }
}
