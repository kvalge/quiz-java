package model;

public class Response {

    private static long id = 1;
    private String content;
    private Boolean correct;
    private long questionId;

    public Response(String content, Boolean correct, long questionId) {
        this.content = content;
        this.correct = correct;
        this.questionId = questionId;
    }

    public static long getId() {
        return id++;
    }

    public String getContent() {
        return content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public long getQuestionId() {
        return questionId;
    }
}
