package Model.bo;

import java.util.List;

import Model.dao.TestDAO;
import Model.bean.*;

public class TestBO {
	TestDAO testDAO = new TestDAO();
	
	public List<TestBEAN> getAllTest(){
		return testDAO.getAllTest();
	}
	
	public void createTest(String Name) {
		testDAO.createTest(Name);
	}
}
