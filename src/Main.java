import database.CreateTableQuery;
import database.DaoQuestion;

public class Main {

    public static void main(String[] args) {

        CreateTableQuery createTableQuery = new CreateTableQuery();
        createTableQuery.addTables();

        DaoQuestion question = new DaoQuestion();
        question.addNewQuestion();
        question.updateQuestion();
//        question.deleteQuestion();
        question.getQuestionByTopic();
    }
}
