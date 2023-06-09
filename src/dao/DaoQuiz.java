package dao;

import database.Configuration;
import model.Question;
import model.Quiz;
import model.Response;
import model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static config.Constants.*;
import static config.QuizTextConst.*;

public class DaoQuiz {

    Configuration configuration = new Configuration();

    Topic t1 = new Topic(TOPIC1_NAME);
    long t1Id = Topic.getId();

    Topic t2 = new Topic(TOPIC2_NAME);
    long t2Id = Topic.getId();

    public void addNewTopic() {

        try {
            Statement statement = configuration.connect().createStatement();

            insertTopic(statement, t1Id, t1.getName());
            insertTopic(statement, t2Id, t2.getName());
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    private void insertTopic(Statement statement, long id, String name) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO " + TABLE_TOPIC + "(id, name)" +
                        "VALUES (" + id + ", '" + name + "')");
    }

    Question q1 = new Question(
            Q1_CONTENT,
            RANK_1,
            t1Id);
    long q1Id = Question.getId();

    Question q2 = new Question(
            Q2_CONTENT,
            RANK_2,
            t1Id);
    long q2Id = Question.getId();

    Question q3 = new Question(
            Q3_CONTENT,
            RANK_3,
            t1Id);
    long q3Id = Question.getId();

    Question q4 = new Question(
            Q4_CONTENT,
            RANK_3,
            t2Id);
    long q4Id = Question.getId();

    public void addNewQuestion() {
        try {
            Statement statement = configuration.connect().createStatement();

            insertQuestion(statement, q1Id, q1.getContent(), q1.getRank(), q1.getTopicId());
            insertQuestion(statement, q2Id, q2.getContent(), q2.getRank(), q2.getTopicId());
            insertQuestion(statement, q3Id, q3.getContent(), q3.getRank(), q3.getTopicId());
            insertQuestion(statement, q4Id, q4.getContent(), q4.getRank(), q4.getTopicId());
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    private void insertQuestion(Statement statement, long id, String content, int rank, long topicId) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                        "VALUES (" + id + ", '" + content + "', " + rank + ", " + topicId + ")");
    }

    public void getQuestionByTopic() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.execute("SELECT * FROM " + TABLE_QUESTION + " WHERE topic_id = " + t1Id);
            ResultSet results = statement.getResultSet();
            System.out.println(t1.getName() + " questions: ");
            while (results.next()) {
                System.out.println(results.getString("content"));
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    public void updateQuestion() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate("UPDATE " + TABLE_QUESTION + " SET rank = " + RANK_1 + " WHERE id = " + q2Id);
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    public void deleteQuestion() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.execute("DELETE FROM " + TABLE_QUESTION + " WHERE id = " + q3Id);
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    Response r1q1 = new Response(R1Q1_CONTENT, false, q1Id);
    Response r2q1 = new Response(R2Q1_CONTENT, true, q1Id);
    Response r3q1 = new Response(R3Q1_CONTENT, false, q1Id);
    Response r1q2 = new Response(R1Q2_CONTENT, false, q2Id);
    Response r2q2 = new Response(R2Q2_CONTENT, false, q2Id);
    Response r3q2 = new Response(R3Q2_CONTENT, true, q2Id);
    Response r1q3 = new Response(R1Q3_CONTENT, true, q3Id);
    Response r2q3 = new Response(R2Q3_CONTENT, false, q3Id);
    Response r3q3 = new Response(R3Q3_CONTENT, false, q3Id);
    Response r1q4 = new Response(R1Q4_CONTENT, false, q4Id);
    Response r2q4 = new Response(R2Q4_CONTENT, false, q4Id);
    Response r3q4 = new Response(R3Q4_CONTENT, true, q4Id);


    public void addNewResponse() {
        try {
            Statement statement = configuration.connect().createStatement();

            insertResponse(statement, Response.getId(), r1q1.getContent(), r1q1.getCorrect(), r1q1.getQuestionId());
            insertResponse(statement, Response.getId(), r2q1.getContent(), r2q1.getCorrect(), r2q1.getQuestionId());
            insertResponse(statement, Response.getId(), r3q1.getContent(), r3q1.getCorrect(), r3q1.getQuestionId());
            insertResponse(statement, Response.getId(), r1q2.getContent(), r1q2.getCorrect(), r1q2.getQuestionId());
            insertResponse(statement, Response.getId(), r2q2.getContent(), r2q2.getCorrect(), r2q2.getQuestionId());
            insertResponse(statement, Response.getId(), r3q2.getContent(), r3q2.getCorrect(), r3q2.getQuestionId());
            insertResponse(statement, Response.getId(), r1q3.getContent(), r1q3.getCorrect(), r1q3.getQuestionId());
            insertResponse(statement, Response.getId(), r2q3.getContent(), r2q3.getCorrect(), r2q3.getQuestionId());
            insertResponse(statement, Response.getId(), r3q3.getContent(), r3q3.getCorrect(), r3q3.getQuestionId());
            insertResponse(statement, Response.getId(), r1q4.getContent(), r1q4.getCorrect(), r1q4.getQuestionId());
            insertResponse(statement, Response.getId(), r2q4.getContent(), r2q4.getCorrect(), r2q4.getQuestionId());
            insertResponse(statement, Response.getId(), r3q4.getContent(), r3q4.getCorrect(), r3q4.getQuestionId());
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    private void insertResponse(Statement statement, long id, String content, boolean correct, long questionId) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                        "VALUES (" + id + ", '" + content + "', " + correct + ", " + questionId + ")");
    }

    Quiz quiz1 = new Quiz("History quiz");
    long quiz1Id = Quiz.getId();
    Quiz quiz2 = new Quiz("Cinema quiz");
    long quiz2Id = Quiz.getId();


    public void addNewQuiz() {
        try {
            Statement statement = configuration.connect().createStatement();

            insertQuiz(statement, quiz1Id, quiz1.getName());
            insertQuiz(statement, quiz2Id, quiz2.getName());
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    private void insertQuiz(Statement statement, long id, String name) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO " + TABLE_QUIZ + "(id, name)" +
                        "VALUES (" + id + ", '" + name + "')");
    }

    // Adds quiz id and question id to the quiz_question table.
    public void addQuestionToQuiz() {
        try {
            Statement statement = configuration.connect().createStatement();

            insertQuestionToQuiz(statement, quiz1Id, q1Id);
            insertQuestionToQuiz(statement, quiz1Id, q2Id);
            insertQuestionToQuiz(statement, quiz1Id, q3Id);
            insertQuestionToQuiz(statement, quiz2Id, q4Id);
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    private void insertQuestionToQuiz(Statement statement, long quizId, long questionId) throws SQLException {
        statement.executeUpdate(
                "INSERT INTO " + TABLE_QUIZ_QUESTION + "(id, " + TABLE_QUIZ + "_id, " + TABLE_QUESTION + "_id)" +
                        "VALUES (DEFAULT, " + quizId + ", " + questionId + ")");
    }

    // Creates a database view to display History quiz questions with the right answer.
    public void createFirstQuizView() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "CREATE VIEW " + VIEW_HISTORY_QUIZ + " AS" +
                            "  SELECT question.content AS question, response.content AS response" +
                            "  FROM question" +
                            "  FULL OUTER JOIN quiz_question ON question.id = quiz_question.question_id" +
                            "  FULL OUTER JOIN response ON question.id = response.question_id" +
                            "  WHERE quiz_question.quiz_id = 1 AND response.correct = TRUE;");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    // Creates a database view to display Cinema quiz questions with the right answer.
    public void createSecondQuizView() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "CREATE VIEW " + VIEW_CINEMA_QUIZ + " AS" +
                            "  SELECT question.content AS question, response.content AS response" +
                            "  FROM question" +
                            "  FULL OUTER JOIN quiz_question ON question.id = quiz_question.question_id" +
                            "  FULL OUTER JOIN response ON question.id = response.question_id" +
                            "  WHERE quiz_question.quiz_id = 2 AND response.correct = TRUE;");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    // Prints History quiz questions and answers to the console.
    List<Question> questions = quiz1.getQuestions();

    public void consoleQuiz() {
        System.out.println(quiz1.getName().toUpperCase());

        quiz1.addQuestions(q1);
        quiz1.addQuestions(q2);
        quiz1.addQuestions(q3);

        q1.addResponse(r1q1);
        q1.addResponse(r2q1);
        q1.addResponse(r3q1);
        q2.addResponse(r1q2);
        q2.addResponse(r2q2);
        q2.addResponse(r3q2);
        q3.addResponse(r1q3);
        q3.addResponse(r2q3);
        q3.addResponse(r3q3);

        getQuestionsAndAnswers(q1, 0);
        getQuestionsAndAnswers(q2, 1);
        getQuestionsAndAnswers(q3, 2);
    }

    public void getQuestionsAndAnswers(Question question, int questionIndex) {
        int i = 1;
        System.out.println(questions.get(questionIndex).getContent());
        List<Response> q1Responses = question.getResponses();
        for (Response r : q1Responses) {
            System.out.println(i + ": " + r.getContent());
            i++;
        }
        for (Response r : q1Responses) {
            if (r.getCorrect()) {
                System.out.println("The right answer is: " + r.getContent());
            }
        }
    }
}
