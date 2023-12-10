package Model.bean;



public class AccountBEAN {
	public int ID_Account;
	public String username;
	public String password;
	public int role;

	public AccountBEAN(int ID_Account, String username, String password, int role) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.ID_Account = ID_Account;
	}

}