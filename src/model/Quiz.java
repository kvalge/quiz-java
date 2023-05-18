package model;

import java.util.List;

public class Quiz {

    private static long id = 1;
    private String name;

    private List<Question> questions;

    public Quiz(String name) {
        this.name = name;
    }

    public static long getId() {
        return id++;
    }

    public String getName() {
        return name;
    }
}
