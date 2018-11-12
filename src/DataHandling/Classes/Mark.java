package DataHandling.Classes;

import DataHandling.Interfaces.MarkInterface;
import DataHandling.Interfaces.SubjectInterface;

public class Mark implements MarkInterface {
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Mark(int rating) {
        this.rating = rating;
    }
}
