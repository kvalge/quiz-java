package database;

import java.sql.SQLException;
import java.sql.Statement;

import static config.Constants.*;

public class CreateTableQuery {

    Configuration configuration = new Configuration();

    public void addTables() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.execute("DROP VIEW IF EXISTS " + VIEW_HISTORY_QUIZ);
            statement.execute("DROP VIEW IF EXISTS " + VIEW_CINEMA_QUIZ);

            statement.execute("DROP TABLE IF EXISTS " + TABLE_TOPIC);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_QUESTION);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_RESPONSE);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_QUIZ);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_QUIZ_QUESTION);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TOPIC + " (id INTEGER PRIMARY KEY, name TEXT, UNIQUE(name))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " (id INTEGER PRIMARY KEY, content TEXT, rank INTEGER, " + TABLE_TOPIC + "_id INTEGER, UNIQUE(content))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_RESPONSE + " (id INTEGER PRIMARY KEY, content TEXT, correct BOOLEAN, " + TABLE_QUESTION + "_id INTEGER, UNIQUE(content))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUIZ + " (id INTEGER PRIMARY KEY, name TEXT, UNIQUE(name))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUIZ_QUESTION + " (id SERIAL PRIMARY KEY, " + TABLE_QUIZ + "_id INTEGER," + TABLE_QUESTION + "_id INTEGER, UNIQUE(question_id))");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }
}
