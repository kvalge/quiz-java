import dao.DaoQuestion;
import database.CreateTableQuery;

public class Main {

    public static void main(String[] args) {

        CreateTableQuery createTableQuery = new CreateTableQuery();
        createTableQuery.addTables();

        DaoQuestion question = new DaoQuestion();
        question.addNewTopic();
        question.addNewQuestion();
        question.updateQuestion();
//        question.deleteQuestion();
        question.getQuestionByTopic();
        question.addNewResponse();
    }
}
