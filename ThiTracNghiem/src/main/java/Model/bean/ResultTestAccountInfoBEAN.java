package Model.bean;

import java.util.ArrayList;
import java.util.List;

import Model.bo.*;
import Model.dao.AccountInfoDAO;
import Model.dao.ResultDAO;
import Model.dao.TestDAO;

public class ResultTestAccountInfoBEAN {
	public int ID_Result;
	public int ID_Test;
	public int ID_Account;
	
	public ResultBEAN result;
	public TestBEAN test;
	public AccountBEAN account;
	public AccountInfoBEAN info;
	
	public int mark;
	public String testName;
	public String MSSV;
	TestDAO testDAO = new TestDAO();
	AccountInfoDAO accountInfoDAO = new AccountInfoDAO();
	ResultDAO resultDAO = new ResultDAO();
	public ResultTestAccountInfoBEAN() {
		
	}
	public ResultTestAccountInfoBEAN(int ID_Test, int ID_Account) {
		this.ID_Account = ID_Account;
		this.ID_Test = ID_Test;
		
		List<TestBEAN> testList = testDAO.getAllTest();
		for(TestBEAN test: testList) {
			if(test.ID_Test == ID_Test) {
				this.test = test;
			}
		}
		
		List<AccountInfoBEAN> infoList = accountInfoDAO.getAllStudentInfo();
		for(AccountInfoBEAN infoo: infoList) {
			System.out.println("ID Account Info: " + infoo.ID_Account);
			if(infoo.ID_Account == ID_Account) {
				this.info = infoo;
				System.out.println("ID Info: " + info.ID_Info);
				System.out.println("MSSV: " + info.MSSV);

			}
		}
		System.out.println("ID Info: " + info.ID_Info);
		System.out.println("MSSV: " + info.MSSV);
		List<ResultBEAN> resultList = resultDAO.getAllResult();
		for(ResultBEAN result: resultList) {
			if(result.ID_Account == ID_Account && result.ID_Test == ID_Test) {
				this.result = result;
			}
		}
	
	}
	
	public List<ResultTestAccountInfoBEAN> getAllByIDTest(int ID_Test) {
		List<ResultTestAccountInfoBEAN> list = new ArrayList();
		List<TestBEAN> testList =  new ArrayList();
		
		List<ResultBEAN> resultList = resultDAO.getAllResult();
		System.out.println("ID Test" + ID_Test);
		for(ResultBEAN result: resultList) {
			if(result.ID_Test == ID_Test) {
				System.out.println("Result ID " + result.ID_Result);
				System.out.println("ID_Account "  + result.ID_Account);
				ResultTestAccountInfoBEAN sv = new ResultTestAccountInfoBEAN(result.ID_Test, result.ID_Account);
				System.out.println("MSSV trong list" + sv.info.MSSV);
				list.add(sv);	
			}
		}
		return list;
		
	}

}
