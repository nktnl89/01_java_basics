package DataHandling.Classes;

import DataHandling.Interfaces.MarkInterface;
import DataHandling.Interfaces.Subject;

public class Mark implements MarkInterface {
    private int rating;
    private Subject subject;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Mark(int rating, Subject subject) {

        this.rating = rating;
        this.subject = subject;
    }
}
