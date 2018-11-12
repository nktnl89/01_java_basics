package DataHandling.Interfaces;

import DataHandling.Classes.Student;

import java.util.ArrayList;

public interface StudentGroupInterface {
    public void showListResult(ArrayList<Student> studentsList);

    public void showListResultSortAverage();

    public void showListResultSortTimeRemaining();

    public void showListResultSortSentence();

    public void addStudentIntoGroup(Student student);

    public ArrayList<Student> showFilteredStudentsBySentence(boolean filterValue);
}
