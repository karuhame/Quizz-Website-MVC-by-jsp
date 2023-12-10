package Model.bean;

public class AccountInfoBEAN {
	public int ID_Info;
	public String Name;
	public String MSSV;
	public String LSH;
	public int ID_Account;
	
	public  AccountInfoBEAN(int ID_Info, int ID_Account, String Name, String MSSV, String LSH) {
		this.Name = Name;
		this.MSSV = MSSV;
		this.LSH = LSH;
		this.ID_Account = ID_Account;
		this.ID_Info = ID_Info;
	}
}
