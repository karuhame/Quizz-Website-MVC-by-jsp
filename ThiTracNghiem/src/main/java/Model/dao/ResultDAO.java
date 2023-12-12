package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.bean.QuestionBEAN;
import Model.bean.ResultBEAN;

public class ResultDAO {
	public void submitResult(int ID_Test, int ID_Account, int Mark) {
		
	}
	public void createResult(int ID_Test, int ID_Account, int Mark) {
		try {
            Connection conn  = new ConnectionJDBC().getConn();
			String query = "INSERT INTO result"
					+ "(ID_Test,ID_Account,Mark)"
					+" VALUES (?, ?, ?)";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    
		    // Gán các giá trị cho các tham số trong câu lệnh truy vấn
		    stmt.setInt(1, ID_Test);
		    stmt.setInt(2, ID_Account);
		    stmt.setInt(3, Mark);


		    // Thực thi câu lệnh truy vấn để chèn sinh viên vào cơ sở dữ liệu
		    stmt.executeUpdate();
            // Close the prepared statement
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential errors
        }
	}
	public void updateResult(int ID_Test, int ID_Account, int Mark) {
		try {
			Connection conn  = new ConnectionJDBC().getConn();
			String query = "UPDATE result "
            +"SET Mark = ? " 
					+"WHERE ID_Account = ? AND ID_Test =?";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    
		    // Gán các giá trị cho các tham số trong câu lệnh truy vấn
		    stmt.setInt(2, ID_Account);
		    stmt.setInt(3, ID_Test);
		    stmt.setInt(1, Mark);
		    		    
		    // Thực thi câu lệnh truy vấn để cập nhật thông tin vacxin trong cơ sở dữ liệu
		    stmt.executeUpdate();

            // Close the prepared statement
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential errors
        }
	}
	public List<ResultBEAN> getAllResult(){
		List<ResultBEAN> list = new ArrayList();
		try {
			String sql = "SELECT * " +
                    "FROM result ";
            Connection conn  = new ConnectionJDBC().getConn();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
	
			while (resultSet.next()) {
				int ID_Result = resultSet.getInt("ID_Result");
				int Mark = resultSet.getInt("Mark");
				int ID_Test = resultSet.getInt("ID_Test");
				int ID_Account = resultSet.getInt("ID_Account");

				ResultBEAN sv = new ResultBEAN(ID_Result, ID_Test, Mark, ID_Account);
				list.add(sv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	

}
