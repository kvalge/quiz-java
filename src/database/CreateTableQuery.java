package database;

import java.sql.SQLException;
import java.sql.Statement;

import static config.Constants.*;

public class CreateTableQuery {

    Configuration configuration = new Configuration();

    public void addTables() {
        try {
            Statement statement = configuration.connect().createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TOPIC + " (id INTEGER PRIMARY KEY, name TEXT, UNIQUE(name))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " (id INTEGER PRIMARY KEY, content TEXT, rank INTEGER, " + TABLE_TOPIC + "_id INTEGER, UNIQUE(content))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_RESPONSE + " (id INTEGER PRIMARY KEY, content TEXT, correct BOOLEAN, " + TABLE_QUESTION + "_id INTEGER, UNIQUE(content))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUIZ + " (id INTEGER PRIMARY KEY, name TEXT, UNIQUE(name))");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_QUIZ_QUESTION + " (id INTEGER PRIMARY KEY,  " + TABLE_QUIZ + "_id INTEGER," + TABLE_QUESTION + "_id INTEGER, UNIQUE(id))");
        } catch (SQLException e) {
            System.out.println(QUERY_FAILED + e.getMessage());
            e.getStackTrace();
        }
    }
}
