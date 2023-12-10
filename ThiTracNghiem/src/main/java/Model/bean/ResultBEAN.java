package Model.bean;

public class ResultBEAN {
	public int ID_Result;
	public int Mark;
	public int ID_Account;
	public int ID_Test;
	
	public ResultBEAN(int ID_Result, int ID_Test, int Mark, int ID_Account) {
		this.ID_Test = ID_Test;
		this.Mark = Mark;
		this.ID_Account = ID_Account;
		this.ID_Result = ID_Result;
	}
}
