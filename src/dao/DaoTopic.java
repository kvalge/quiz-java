package dao;

import database.Configuration;
import model.Topic;

import java.sql.SQLException;
import java.sql.Statement;

public class DaoTopic {

    public static final String TABLE_TOPIC = "topic";
    public static final String QUERY_FAILED = "Query failed: ";
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
                            "VALUES (" + Topic.getId() + ", '" + t1.getName() + "')");
            statement.executeUpdate(
                    "INSERT INTO " + TABLE_TOPIC + "(id, name)" +
                            "VALUES (" + Topic.getId() + ", '" + t2.getName() + "')");

        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }
}
