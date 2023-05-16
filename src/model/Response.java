package model;

public class Response {

    private static long id = 1;
    private String text;
    private Boolean correct;
    private Question question;

    public Response(String text, Boolean correct, Question question) {
        this.text = text;
        this.correct = correct;
        this.question = question;
    }

    public long getId() {
        return id++;
    }

    public String getText() {
        return text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public Question getQuestion() {
        return question;
    }
}
