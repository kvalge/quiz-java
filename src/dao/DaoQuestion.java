package dao;

import database.Configuration;
import model.Question;
import model.Response;
import model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static config.Constants.*;

public class DaoQuestion {

    Configuration configuration = new Configuration();

    Topic t1 = new Topic("History");
    long idT1 = Topic.getId();

    Topic t2 = new Topic("Cinema");
    long idT2 = Topic.getId();

    public void addNewTopic() {

        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_TOPIC + "(id, name)" +
                            "VALUES (" + idT1 + ", '" + t1.getName() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_TOPIC + "(id, name)" +
                            "VALUES (" + idT2 + ", '" + t2.getName() + "')");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    Question q1 = new Question(
            "Which country was known as Rhodesia before gaining independence from the British in 1979?",
            RANK_1,
            idT1);
    long q1Id = Question.getId();

    Question q2 = new Question(
            "Which country was unified by Giuseppe Garibaldi in 1851?",
            RANK_2,
            idT1);
    long q2Id = Question.getId();

    Question q3 = new Question(
            "Which President was brought down by the Watergate Scandal?",
            RANK_3,
            idT1);
    long q3Id = Question.getId();

    Question q4 = new Question(
            "Who directed Lost in Translation?",
            RANK_3,
            idT2);
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

            statement.execute("SELECT * FROM " + TABLE_QUESTION + " WHERE topic_id = 1");
            ResultSet results = statement.getResultSet();
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

            statement.executeUpdate("UPDATE " + TABLE_QUESTION + " SET rank = " + RANK_1 + " WHERE id = 4");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    public void deleteQuestion() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.execute("DELETE FROM " + TABLE_QUESTION + " WHERE id = 4");
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
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

/*    Quiz quiz1 = new Quiz(Question.getId());

    public void addNewQuiz() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUIZ + "(id" + TABLE_QUESTION + "_id)" +
                            "VALUES (" + Quiz.getId() + ", '" + r1q1.getQuestionId() + "')");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }*/

}
