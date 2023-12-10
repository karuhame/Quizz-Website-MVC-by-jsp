package Model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.bean.AccountInfoBEAN;


public class AccountInfoDAO {
	
	public List<AccountInfoBEAN> getAllStudentInfo(){
		List<AccountInfoBEAN> list = new ArrayList();
		try {
			String sql = "SELECT ai.ID_Info, ai.ID_Account, ai.Name, ai.MSSV, ai.LSH " +
                    "FROM account AS a " +
                    "JOIN account_info AS ai ON a.ID_Account = ai.ID_Account " +
                    "WHERE a.role = 1";
            Connection conn  = new ConnectionJDBC().getConn();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
	
			while (resultSet.next()) {
				int ID_Info = resultSet.getInt("ID_Info");
				int ID_Account = resultSet.getInt("ID_Account");
				String name = resultSet.getString("Name");
				String mssv = resultSet.getString("MSSV");
				String lsh = resultSet.getString("LSH");
				
				AccountInfoBEAN sv = new AccountInfoBEAN(ID_Info, ID_Account, name, mssv, lsh);
				list.add(sv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
