package model;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private static long id = 1;
    private String content;
    private int rank;
    private long topicId;
    private List<Response> responses = new ArrayList<>();

    public Question(String content, int rank, long topicId) {
        this.content = content;
        this.rank = rank;
        this.topicId = topicId;
    }

    public static long getId() {
        return id++;
    }

    public String getContent() {
        return content;
    }

    public int getRank() {
        return rank;
    }

    public long getTopicId() {
        return topicId;
    }

    public List<Response> addResponse(Response response) {
        responses.add(response);
        return responses;
    }
}
