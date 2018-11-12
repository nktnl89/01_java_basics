package DataHandling.Classes;

public class Subject implements DataHandling.Interfaces.Subject {
    private String name;
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}
