package dao;

import database.Configuration;
import model.Question;
import model.Quiz;
import model.Response;
import model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static config.Constants.*;

public class DaoQuiz {

    Configuration configuration = new Configuration();

    Topic t1 = new Topic("History");
    long t1Id = Topic.getId();

    Topic t2 = new Topic("Cinema");
    long t2Id = Topic.getId();

    public void addNewTopic() {

        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_TOPIC + "(id, name)" +
                            "VALUES (" + t1Id + ", '" + t1.getName() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_TOPIC + "(id, name)" +
                            "VALUES (" + t2Id + ", '" + t2.getName() + "')");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    Question q1 = new Question(
            "Which country was known as Rhodesia before gaining independence from the British in 1979?",
            RANK_1,
            t1Id);
    long q1Id = Question.getId();

    Question q2 = new Question(
            "Which country was unified by Giuseppe Garibaldi in 1851?",
            RANK_2,
            t1Id);
    long q2Id = Question.getId();

    Question q3 = new Question(
            "Which President was brought down by the Watergate Scandal?",
            RANK_3,
            t1Id);
    long q3Id = Question.getId();

    Question q4 = new Question(
            "Who directed Lost in Translation?",
            RANK_3,
            t2Id);
    long q4Id = Question.getId();

    public void addNewQuestion() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + q1Id + ", '" + q1.getContent() + "', " + q1.getRank()
                            + ", '" + q1.getTopicId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + q2Id + ", '" + q2.getContent() + "', " + q2.getRank()
                            + ", '" + q2.getTopicId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + q3Id + ", '" + q3.getContent() + "', " + q3.getRank()
                            + ", '" + q3.getTopicId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + q4Id + ", '" + q4.getContent() + "', " + q4.getRank()
                            + ", '" + q4.getTopicId() + "')");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
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

    Response r1q1 = new Response("India", false, q1Id);
    Response r2q1 = new Response("Zimbabwe", true, q1Id);
    Response r3q1 = new Response("Sierra-Leone", false, q1Id);
    Response r1q2 = new Response("Spain", false, q2Id);
    Response r2q2 = new Response("Switzerland", false, q2Id);
    Response r3q2 = new Response("Italy", true, q2Id);
    Response r1q3 = new Response("Richard M. Nixon", true, q3Id);
    Response r2q3 = new Response("George W. Bush", false, q3Id);
    Response r3q3 = new Response("John F. Kennedy", false, q3Id);
    Response r1q4 = new Response("Jodie Foster", false, q4Id);
    Response r2q4 = new Response("Julie Delpy", false, q4Id);
    Response r3q4 = new Response("Sofia Coppola", true, q4Id);


    public void addNewResponse() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r1q1.getContent() + "', " + r1q1.getCorrect()
                            + ", '" + r1q1.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r2q1.getContent() + "', " + r2q1.getCorrect()
                            + ", '" + r2q1.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r3q1.getContent() + "', " + r3q1.getCorrect()
                            + ", '" + r2q1.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r1q2.getContent() + "', " + r1q2.getCorrect()
                            + ", '" + r1q2.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r2q2.getContent() + "', " + r2q2.getCorrect()
                            + ", '" + r2q2.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r3q2.getContent() + "', " + r3q2.getCorrect()
                            + ", '" + r3q2.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r1q3.getContent() + "', " + r1q3.getCorrect()
                            + ", '" + r1q3.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r2q3.getContent() + "', " + r2q3.getCorrect()
                            + ", '" + r2q3.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r3q3.getContent() + "', " + r3q3.getCorrect()
                            + ", '" + r3q3.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r1q4.getContent() + "', " + r1q4.getCorrect()
                            + ", '" + r1q4.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r2q4.getContent() + "', " + r2q4.getCorrect()
                            + ", '" + r2q4.getQuestionId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_RESPONSE + "(id, content, correct, " + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Response.getId() + ", '" + r3q4.getContent() + "', " + r3q4.getCorrect()
                            + ", '" + r3q4.getQuestionId() + "')");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    Quiz quiz1 = new Quiz("First quiz");
    long quiz1Id = Quiz.getId();
    Quiz quiz2 = new Quiz("Second quiz");
    long quiz2Id = Quiz.getId();


    public void addNewQuiz() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUIZ + "(id, name)" +
                            "VALUES (" + quiz1Id + ", '" + quiz1.getName() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUIZ + "(id, name)" +
                            "VALUES (" + quiz2Id + ", '" + quiz2.getName() + "')");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    // Creates a quiz_question table with quiz id and question id.
    public void addQuestionToQuiz() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUIZ_QUESTION + "(id, " + TABLE_QUIZ + "_id, " + TABLE_QUESTION + "_id)" +
                            "VALUES (DEFAULT, " + quiz1Id + ", " + q1Id + ")");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUIZ_QUESTION + "(id, " + TABLE_QUIZ + "_id, " + TABLE_QUESTION + "_id)" +
                            "VALUES (DEFAULT, " + quiz1Id + ", " + q2Id + ")");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUIZ_QUESTION + "(id, " + TABLE_QUIZ + "_id, " + TABLE_QUESTION + "_id)" +
                            "VALUES (DEFAULT, " + quiz1Id + ", " + q3Id + ")");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUIZ_QUESTION + "(id, " + TABLE_QUIZ + "_id, " + TABLE_QUESTION + "_id)" +
                            "VALUES (DEFAULT, " + quiz2Id + ", " + q4Id + ")");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    // Creates a view to display first history quiz questions with right answer.
    public void createFirstQuizView() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "CREATE VIEW first_quiz_view AS" +
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

    // Creates a view to display second cinema quiz questions with right answer.
    public void createSecondQuizView() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "CREATE VIEW second_quiz_view AS" +
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
}
