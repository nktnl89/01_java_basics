package DataHandling.Classes;

import DataHandling.Interfaces.CurriculumInterface;

import java.util.ArrayList;
import java.util.Date;

public class Curriculum implements CurriculumInterface {
    private ArrayList<Subject> subjects = new ArrayList<Subject>();
    private String name;

    public Curriculum(ArrayList<Subject> subjects, String name, Date startDate) {
        this.subjects = subjects;
        this.name = name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
