package dao;

import database.Configuration;
import model.Question;
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
            System.out.println("DaoTopic class get id1: " + idT1);
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_TOPIC + "(id, name)" +
                            "VALUES (" + idT2 + ", '" + t2.getName() + "')");
            System.out.println("DaoTopic class get id2: " + idT2);

        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }
    Question q1 = new Question(
            "Which country was known as Rhodesia before gaining independence from the British in 1979?",
            RANK_1,
            idT1);

    Question q2 = new Question(
            "Which country was unified by Giuseppe Garibaldi in 1851?",
            RANK_2,
            idT1);

    Question q3 = new Question(
            "Which President was brought down by the Watergate Scandal?",
            RANK_3,
            idT1);

    Question q4 = new Question(
            "Who directed Lost in Translation?",
            RANK_3,
            idT2);

    public void addNewQuestion() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q1.getContent() + "', " + q1.getRank()
                            + ", '" + q1.getTopicId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q2.getContent() + "', " + q2.getRank()
                            + ", '" + q2.getTopicId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q3.getContent() + "', " + q3.getRank()
                            + ", '" + q3.getTopicId() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q4.getContent() + "', " + q4.getRank()
                            + ", '" + q4.getTopicId() + "') ON CONFLICT (content) DO NOTHING");
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

            statement.executeUpdate("UPDATE " + TABLE_QUESTION + " SET rank = " + RANK_1 +" WHERE id = 3");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }

    public void deleteQuestion() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.execute("DELETE FROM " + TABLE_QUESTION + " WHERE id = 1");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }
}
