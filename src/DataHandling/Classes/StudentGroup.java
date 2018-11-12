package DataHandling.Classes;

import DataHandling.Interfaces.StudentGroupInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentGroup implements StudentGroupInterface {
    private ArrayList<Student> students = new ArrayList<Student>();

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
    public void showListResult(ArrayList<Student> studentsList) {
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
        Comparator<Student> comparator = Comparator.comparing(obj -> obj.getAverageMark());
        Collections.sort(students, comparator);
        showListResult(students);
    }

    @Override
    public void showListResultSortTimeRemaining() {
        Comparator<Student> comparator = Comparator.comparing(obj -> obj.getRemainingTime());
        Collections.sort(students, comparator);
        showListResult(students);
    }

    @Override
    public void showListResultSortSentence() {
        System.out.println("Студенты к отчислению:");
        showListResult(showFilteredStudentsBySentence(false));
        System.out.println("Студенты могут продолжить обучение:");
        showListResult(showFilteredStudentsBySentence(true));
    }

    @Override
    public void addStudentIntoGroup(Student student) {
        students.add(student);
    }

    @Override
    public ArrayList<Student> showFilteredStudentsBySentence(boolean filterValue) {
        ArrayList<Student> filteredStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getSentence() == filterValue) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}
