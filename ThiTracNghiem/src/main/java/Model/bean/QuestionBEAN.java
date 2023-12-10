package Model.bean;

public class QuestionBEAN {
	public int ID_Question;
	public String name;
	public String opt1;
	public String opt2;
	public String opt3;
	public String opt4;
	public String answer;
	public int ID_Test;
	
	public QuestionBEAN(int ID_Question, int ID_Test, String name, String opt1, String opt2, String opt3, String opt4, String answer) {
		this.ID_Test =  ID_Test;
		this.name = name;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.answer = answer;
		this.ID_Question = ID_Question;
	}

}
