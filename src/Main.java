import dao.DaoTopic;
import database.CreateTableQuery;
import dao.DaoQuestion;

public class Main {

    public static void main(String[] args) {

        CreateTableQuery createTableQuery = new CreateTableQuery();
        createTableQuery.addTables();

        DaoTopic topic = new DaoTopic();
        topic.addNewTopic();

        DaoQuestion question = new DaoQuestion();
        question.addNewQuestion();
        question.updateQuestion();
//        question.deleteQuestion();
        question.getQuestionByTopic();
    }
}
