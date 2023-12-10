package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.bean.*;

import Model.bean.AccountInfoBEAN;
import Model.bean.TestBEAN;


public class TestDAO {
	public List<TestBEAN> getAllTest(){
		List<TestBEAN> list = new ArrayList();
		try {
			String sql = "SELECT *" +
                    "FROM test ";
                    
            Connection conn  = new ConnectionJDBC().getConn();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
	
			while (resultSet.next()) {
				int ID_Test = resultSet.getInt("ID_Test");
				String Name = resultSet.getString("Name");
				
				TestBEAN test = new TestBEAN(ID_Test, Name);
				list.add(test);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public void createTest(String Name) {
		try {
            Connection conn  = new ConnectionJDBC().getConn();
			String query = "INSERT INTO test (Name) VALUES (?)";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    
		    // Gán các giá trị cho các tham số trong câu lệnh truy vấn
		    stmt.setString(1, Name);
		    
		    // Thực thi câu lệnh truy vấn để chèn sinh viên vào cơ sở dữ liệu
		    stmt.executeUpdate();

            // Close the prepared statement
            stmt.close();
            conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
