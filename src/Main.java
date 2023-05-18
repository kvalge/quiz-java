import dao.DaoQuiz;
import database.CreateTableQuery;

public class Main {

    public static void main(String[] args) {

        CreateTableQuery createTableQuery = new CreateTableQuery();
        createTableQuery.addTables();

        DaoQuiz quiz = new DaoQuiz();
        quiz.addNewTopic();
        quiz.addNewQuestion();
        quiz.updateQuestion();
//        quiz.deleteQuestion();
        quiz.getQuestionByTopic();
        quiz.addNewResponse();
        quiz.addNewQuiz();
        quiz.addQuestionToQuiz();
        quiz.createFirstQuizView();
        quiz.createSecondQuizView();
    }
}
