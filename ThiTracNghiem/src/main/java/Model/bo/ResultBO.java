package Model.bo;

import java.util.List;

import Model.bean.*;
import Model.dao.*;


public class ResultBO {

	ResultDAO resultDAO = new ResultDAO();
	public void submitResult(int ID_Test, int ID_Account, int Mark) {
		List<ResultBEAN> list = this.getAllResult();
		boolean check = true;
		for(ResultBEAN result: list) {
			// kiểm tra xem có tồn tại chưa
			if(result.ID_Account == ID_Account && result.ID_Test == ID_Test) {
				check = false;
			}
		}
		if(check) {
			resultDAO.createResult(ID_Test, ID_Account, Mark);
		}
		else {
			resultDAO.updateResult(ID_Account, Mark);
		}
	}
	public List<ResultBEAN> getAllResult(){
		return resultDAO.getAllResult();
	}
	 
}
