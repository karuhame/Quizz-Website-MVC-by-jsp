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
			if(infoo.ID_Account == ID_Account) {
				this.info = infoo;

			}
		}
		List<ResultBEAN> resultList = resultDAO.getAllResult();
		for(ResultBEAN result: resultList) {
			if(result.ID_Account == ID_Account && result.ID_Test == ID_Test) {
				this.result = result;
				System.out.println(result.Mark);
			}
		}
	
	}
	
	public List<ResultTestAccountInfoBEAN> getAllByIDTest(int ID_Test) {
		List<ResultTestAccountInfoBEAN> list = new ArrayList();
		List<TestBEAN> testList =  new ArrayList();
		
		List<ResultBEAN> resultList = resultDAO.getAllResult();
		for(ResultBEAN result: resultList) {
			if(result.ID_Test == ID_Test) {
				ResultTestAccountInfoBEAN sv = new ResultTestAccountInfoBEAN(result.ID_Test, result.ID_Account);
				list.add(sv);		
			}
		}
		return list;	
	}
	public List<ResultTestAccountInfoBEAN> getAllByID_Account(int ID_Account,int ID_Test) {
		List<ResultTestAccountInfoBEAN> list = getAllByIDTest(ID_Test);
		List<ResultTestAccountInfoBEAN> result = new ArrayList();
		for(ResultTestAccountInfoBEAN temp: list) {
			if(temp.info.ID_Account == ID_Account) {
				result.add(temp);
			}
		}
		return result;
	}
}
