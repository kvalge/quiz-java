package database;

import model.Question;
import model.Topic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DaoQuestion {

    public static final String TABLE_TOPIC = "topic";
    public static final String TABLE_QUESTION = "question";

    public static final int RANK_1 = 1;
    public static final int RANK_2 = 2;
    public static final int RANK_3 = 3;

    public static final String QUERY_FAILED = "Query failed: ";
    Configuration configuration = new Configuration();

    public void addNewQuestion() {
        Topic t1 = new Topic("History");
        long idT1 = Topic.getId();

        Topic t2 = new Topic("Cinema");
        long idT2 = Topic.getId();

        Question q1 = new Question(
                "Which country was known as Rhodesia before gaining independence from the British in 1979?",
                RANK_1,
                t1);

        Question q2 = new Question(
                "Which country was unified by Giuseppe Garibaldi in 1851?",
                RANK_2,
                t1);

        Question q3 = new Question(
                "Which President was brought down by the Watergate Scandal?",
                RANK_3,
                t1);

        Question q4 = new Question(
                "Who directed Lost in Translation",
                RANK_3,
                t2);

        try {
            Statement statement = configuration.connect().createStatement();

            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q1.getContent() + "', " + q1.getRank()
                            + ", '" + idT1 + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q2.getContent() + "', " + q2.getRank()
                            + ", '" + idT1 + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q3.getContent() + "', " + q3.getRank()
                            + ", '" + idT1 + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_QUESTION + "(id, content, rank, " + TABLE_TOPIC + "_id)" +
                            "VALUES (" + Question.getId() + ", '" + q4.getContent() + "', " + q4.getRank()
                            + ", '" + idT2 + "') ON CONFLICT (content) DO NOTHING");
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
