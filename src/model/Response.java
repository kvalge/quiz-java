package model;

public class Response {

    private static long id = 1;
    private String content;
    private Boolean correct;
    private Question question;

    public Response(String content, Boolean correct, Question question) {
        this.content = content;
        this.correct = correct;
        this.question = question;
    }

    public long getId() {
        return id++;
    }

    public String getContent() {
        return content;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public Question getQuestion() {
        return question;
    }
}
