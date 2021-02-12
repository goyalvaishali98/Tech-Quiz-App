package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;

public class QuestionDAO {
    public static void addQuestions(QuestionStore qStore)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<Question> questionList = qStore.getAllQuestions();
        for(Question q: questionList){
            ps.setString(1, q.getExamId());
            ps.setInt(2, q.getQno());
            ps.setString(3, q.getQuestion());
            ps.setString(4, q.getAnswer1());
            ps.setString(5, q.getAnswer2());
            ps.setString(6, q.getAnswer3());
            ps.setString(7, q.getAnswer4());
            ps.setString(8, q.getCorrectAnswer());
            ps.setString(9, q.getLanguage());
            ps.executeUpdate();
        }
    }
    public static ArrayList<Question> getQuestionsByExamId(String examId)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("select * from questions where examid=?");
        ps.setString(1, examId);
        ResultSet rs = ps.executeQuery();
        ArrayList<Question> questionList = new ArrayList<>();
        while(rs.next()){
            int qno = rs.getInt(2);
            String question = rs.getString(3);
            String option1 = rs.getString(4);
            String option2 = rs.getString(5);
            String option3 = rs.getString(6);
            String option4 = rs.getString(7);
            String correctOption = rs.getString(8);
            String language = rs.getString(9);
            Question obj = new Question(examId,qno,language,option1,option2,option3,option4,correctOption,question);
            questionList.add(obj);
        }
        return questionList;
    }
    public static void updateQuestions(QuestionStore qStore)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("update questions set QUESTION=?,ANSWER1=?,ANSWER2=?,ANSWER3=?,ANSWER4=?,CORRECT_ANSWER=? where examid=? and qno=?");
        ArrayList<Question> questionList = qStore.getAllQuestions();
        for(Question q: questionList){
            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getAnswer1());
            ps.setString(3, q.getAnswer2());
            ps.setString(4, q.getAnswer3());
            ps.setString(5, q.getAnswer4());
            ps.setString(6, q.getCorrectAnswer());
            ps.setString(7, q.getExamId());
            ps.setInt(8, q.getQno());
            ps.executeUpdate();
        }
    }
}
