package Model.bo;

import Model.dao.*;

import java.util.ArrayList;
import java.util.List;

import Model.bean.*;

public class QuestionBO {
	QuestionDAO questionDAO = new QuestionDAO();
	
	public List<QuestionBEAN> getAllQuestion(){
		return questionDAO.getAllQuestion();
	}	
	public List<QuestionBEAN> getAllQuestionByIDTest(int ID_Test){
		List<QuestionBEAN> list = this.getAllQuestion();
		List<QuestionBEAN> result = new ArrayList();
		for(QuestionBEAN question: list) {
			if(question.ID_Test == ID_Test) {
				result.add(question);
			}
		}
		return result;
	}
	public void createQuestion(int ID_Test, String name, String opt1, String opt2, String opt3, String opt4, String answer) {
		questionDAO.createQuestion(ID_Test, name, opt1, opt2,opt3,opt4,answer);
	}
	public void updateQuestion(int ID_Question,String name, String opt1, String opt2, String opt3, String opt4, String answer) {
		questionDAO.updateQuestion(ID_Question, name, opt1, opt2,opt3,opt4,answer);
	}
	public void deleteQuestion(int ID_Question) {
		questionDAO.deleteQuestion(ID_Question);
	}
	public boolean checkAnswer(int ID_Test, int ID_Question, String answer) {
		List<QuestionBEAN> list = getAllQuestionByIDTest(ID_Test);
		boolean check = false;
		for(QuestionBEAN question: list) {
			if(question.ID_Question == ID_Question) {
				if(question.answer.equals(answer)) {
					check = true;
				}
			}
		}
		return check;
	}
	
	public int getMark(int ID_Test, int point) {
		List<QuestionBEAN> list = this.getAllQuestionByIDTest(ID_Test);
		return 10*(int)point/list.size();
	}
	
	public QuestionBEAN getQuestionByID(int ID_Question) {
		List<QuestionBEAN> list = this.getAllQuestion();
		for(QuestionBEAN question: list) {
			if(question.ID_Question == ID_Question) {
				return question;
			}
		}
		return null;
	}
}
