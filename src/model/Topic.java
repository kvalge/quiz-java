package model;

public class Topic {

    private static long id = 1;
    private String name;

    public Topic(String name) {
        this.name = name;
    }

    public static long getId() {
        return id++;
    }

    public String getName() {
        return name;
    }
}
