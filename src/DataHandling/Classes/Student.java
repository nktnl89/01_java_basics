package DataHandling.Classes;

import DataHandling.Interfaces.CurriculumInterface;
import DataHandling.Interfaces.StudentInterface;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;

public class Student implements StudentInterface {
    private Curriculum curriculum;
    private String name;
    private ArrayList<Mark> marks = new ArrayList<Mark>();
    private boolean chanceForJobOffer;

    public Student(String name) {
        this.name = name;
    }

    public boolean isChanceForJobOffer() {
        return chanceForJobOffer;
    }

    public void setChanceForJobOffer(boolean chanceForJobOffer) {
        this.chanceForJobOffer = chanceForJobOffer;
    }

    public Student(Curriculum curriculum, String name, ArrayList<Mark> marks) {
        this.curriculum = curriculum;
        this.name = name;
        this.marks = marks;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Mark> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    public static Comparator<Student> StuNameComparator = new Comparator<Student>() {

        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getName().toUpperCase();
            String StudentName2 = s2.getName().toUpperCase();
            return StudentName1.compareTo(StudentName2);
        }
    };

    private double getFormattedDouble(double doubleValue) {
        return new BigDecimal(doubleValue).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public int getRemainingTime() {
        return getSumDurationTime() - marks.size() * 8;
    }

    @Override
    public Boolean getSentence() {
        int sumDurationHours = getSumDurationTime();
        int sumCurrentHours = getCurrentTime();
        boolean result = false;
        if (sumDurationHours - sumCurrentHours <= 8) {
            result = (getAverageMark() < 4.5);
        } else {
            int countRemainingDays = (sumDurationHours - sumCurrentHours) / 8;
            int sum = 0;
            for (Mark mark : marks) {
                sum = sum + mark.getRating();
            }
            int finalMarkSum = countRemainingDays * 5 + sum;
            double newAverageMark = getFormattedDouble((double) finalMarkSum / (marks.size() + countRemainingDays));
            if (newAverageMark >= 4.5) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    @Override
    public Double getAverageMark() {
        double result = 0;
        int currentTime = marks.size();
        if (currentTime > 0) {
            int sum = 0;
            for (Mark mark : marks) {
                sum = sum + mark.getRating();
            }
            result = getFormattedDouble((double) sum / currentTime);
        }
        return result;
    }

    @Override
    public int getCurrentTime() {
        return marks.size() * 8;
    }

    @Override
    public int getSumDurationTime() {
        int result = 0;
        for (Subject subject : curriculum.getSubjects()) {
            result = result + subject.getDuration();
        }
        return result;
    }
}
