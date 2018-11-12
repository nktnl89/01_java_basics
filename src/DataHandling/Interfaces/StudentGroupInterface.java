package DataHandling.Interfaces;

import DataHandling.Classes.Student;

public interface StudentGroupInterface {
    public void showListResult(Student... studentsList);
    public void showListResultSortAverage();
    public void showListResultSortTimeRemaining();
    public void showListResultSortSentence();
}
