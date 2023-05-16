package model;

import java.util.List;

public class Question {

    private static long id = 1;
    private String content;
    private int rank;
    private Topic topic;
    private List<Response> responses;

    public Question(long id, String content, int rank, Topic topic, List<Response> responses) {
        this.id = id;
        this.content = content;
        this.rank = rank;
        this.topic = topic;
        this.responses = responses;
    }

    public long getId() {
        return id++;
    }

    public String getContent() {
        return content;
    }

    public int getRank() {
        return rank;
    }

    public Topic getTopic() {
        return topic;
    }

    public List<Response> getResponses() {
        return responses;
    }
}
