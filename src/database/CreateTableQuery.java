package database;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableQuery {

    public static final String TABLE_TOPIC = "topic";
    public static final String TABLE_QUESTION = "question";
    public static final String TABLE_RESPONSE = "response";
    public static final String TABLE_QUIZ = "quiz";
    public static final String QUERY_FAILED = "Query failed: ";

    Configuration configuration = new Configuration();

    public void addTables() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TOPIC + " (id INTEGER, name TEXT)");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " (id INTEGER, content TEXT, rank INTEGER, " + TABLE_TOPIC + "_id INTEGER, UNIQUE(content))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_RESPONSE + " (id INTEGER, content TEXT, correct BOOLEAN, " + TABLE_QUESTION + "_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUIZ + " (id INTEGER, " + TABLE_QUESTION + "_id INTEGER)");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }
}
