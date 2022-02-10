package day02;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private int length;
    private List<String> actorNames;

    public Movie(String title, int length, List<String> actorNames) {
        this.title = title;
        this.length = length;
        this.actorNames = actorNames;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getActorNames() {
        return actorNames;
    }
}
