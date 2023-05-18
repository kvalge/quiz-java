package model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private static long id = 1;
    private String name;

    private List<Question> questions = new ArrayList<>();

    public Quiz(String name) {
        this.name = name;
    }

    public static long getId() {
        return id++;
    }

    public String getName() {
        return name;
    }

    public void addQuestions(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
