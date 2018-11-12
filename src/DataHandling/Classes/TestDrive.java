package DataHandling.Classes;

import DataHandling.Interfaces.CurriculumInterface;
import DataHandling.Interfaces.StudentGroupInterface;

import java.util.ArrayList;
import java.util.Date;

public class TestDrive {
    public void startTest() {
        //предметы
        ArrayList<Subject> subjectsJ2EE = new ArrayList<Subject>();
        subjectsJ2EE.add(new Subject("Технология Java Servlets", 16));
        subjectsJ2EE.add(new Subject("Struts Framework", 24));
        subjectsJ2EE.add(new Subject("Spring Framework", 48));
        subjectsJ2EE.add(new Subject("Hibernate", 20));

        ArrayList<Subject> subjectsJavaDeveloper = new ArrayList<Subject>();
        subjectsJavaDeveloper.add(new Subject("Обзор технологий Java", 8));
        subjectsJavaDeveloper.add(new Subject("Библиотека JFC/Swing", 16));
        subjectsJavaDeveloper.add(new Subject("Технология JDBC", 16));
        subjectsJavaDeveloper.add(new Subject("Технология JAX", 52));
        subjectsJavaDeveloper.add(new Subject("Библиотеки commons", 44));

        //курсы
        Curriculum curriculumJ2EE = new Curriculum(subjectsJ2EE, "J2EE Developer", new Date());
        Curriculum curriculumJavaDeveloper = new Curriculum(subjectsJavaDeveloper, "Java Developer", new Date());

        //оценки двух студентов
        ArrayList<Mark> marksIvanov = new ArrayList<Mark>();
        marksIvanov.add(new Mark(3));
        marksIvanov.add(new Mark(4));
        marksIvanov.add(new Mark(2));
        marksIvanov.add(new Mark(5));
        marksIvanov.add(new Mark(3));
        marksIvanov.add(new Mark(3));

        ArrayList<Mark> marksPetrov = new ArrayList<Mark>();
        marksPetrov.add(new Mark(4));
        marksPetrov.add(new Mark(5));
        marksPetrov.add(new Mark(3));
        marksPetrov.add(new Mark(5));
        marksPetrov.add(new Mark(5));
        marksPetrov.add(new Mark(5));
        marksPetrov.add(new Mark(5));
        marksPetrov.add(new Mark(2));

        Student studentPetrov = new Student(curriculumJavaDeveloper, "Petrov Petr", marksPetrov);
        Student studentIvanov = new Student(curriculumJ2EE, "Ivanov Ivan", marksIvanov);
        studentIvanov.setChanceForJobOffer(studentIvanov.getSentence());
        studentPetrov.setChanceForJobOffer(studentPetrov.getSentence());

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.addStudentIntoGroup(studentPetrov);
        studentGroup.addStudentIntoGroup(studentIvanov);

        studentGroup.showListResult(studentGroup.getStudents());
        System.out.println("");
        System.out.println("Сортируем по оставшимся часам:");
        studentGroup.showListResultSortTimeRemaining();
        System.out.println("");
        System.out.println("Сортируем по среднему балу:");
        studentGroup.showListResultSortAverage();
        System.out.println("");
        studentGroup.showListResultSortSentence();
    }
}
