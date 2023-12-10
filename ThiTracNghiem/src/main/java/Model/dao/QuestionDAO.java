package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.bean.*;


public class QuestionDAO {
	public List<QuestionBEAN> getAllQuestionByIDTest(int ID_Test){
		List<QuestionBEAN> list = new ArrayList();
		try {
			String sql = "SELECT * " +
                    "FROM question " +
                    "WHERE ID_Test = " + ID_Test;
            Connection conn  = new ConnectionJDBC().getConn();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
	
			while (resultSet.next()) {
				int ID_Question = resultSet.getInt("ID_Question");
				String name = resultSet.getString("name");
				String opt1 = resultSet.getString("opt1");
				String opt2 = resultSet.getString("opt2");
				String opt3 = resultSet.getString("opt3");
				String opt4 = resultSet.getString("opt4");
				String answer = resultSet.getString("answer");
				
				QuestionBEAN sv = new QuestionBEAN(ID_Question, ID_Test, name, opt1, opt2, opt3, opt4, answer);
				list.add(sv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public void createQuestion(int ID_Question, int ID_Test, String name, String opt1, String opt2, String opt3, String opt4, String answer) {
		try {
            Connection conn  = new ConnectionJDBC().getConn();
			String query = "INSERT INTO question"
					+ "(ID_Question, ID_Test, name, opt1, opt2,opt3,opt4,answer)"
					+" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    
		    // Gán các giá trị cho các tham số trong câu lệnh truy vấn
		    stmt.setInt(1, ID_Question);
		    stmt.setInt(2, ID_Test);
		    stmt.setString(3, name);
		    stmt.setString(4, opt1);
		    stmt.setString(5, opt2);
		    stmt.setString(6, opt3);
		    stmt.setString(7, opt4);
		    stmt.setString(8, answer);


		    // Thực thi câu lệnh truy vấn để chèn sinh viên vào cơ sở dữ liệu
		    stmt.executeUpdate();
            // Close the prepared statement
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential errors
        }
	}
	public void updateQuestion(int ID_Question,String name, String opt1, String opt2, String opt3, String opt4, String answer) {
		try {
            Connection conn  = new ConnectionJDBC().getConn();
			String query = "UPDATE question"
            +"SET name = ?, opt1 = ?, opt2 = ?,opt3 = ?,opt4 = ?,answer = ?" 
					+"WHERE ID_Question = ?";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    
		    // Gán các giá trị cho các tham số trong câu lệnh truy vấn
		    stmt.setInt(7, ID_Question);
		    stmt.setString(1, name);
		    stmt.setString(2, opt1);
		    stmt.setString(3, opt2);
		    stmt.setString(4, opt3);
		    stmt.setString(5, opt4);
		    stmt.setString(6, answer);
		    
		    // Thực thi câu lệnh truy vấn để cập nhật thông tin vacxin trong cơ sở dữ liệu
		    stmt.executeUpdate();

            // Close the prepared statement
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential errors
        }
	}
	public void deleteQuestion(int ID_Question) {
		try {
            Connection conn  = new ConnectionJDBC().getConn();
			String query = "DELETE from question"
					+"WHERE ID_Question = ?";
			Statement stmt = conn.createStatement();
		    // Thực thi câu lệnh truy vấn để cập nhật thông tin vacxin trong cơ sở dữ liệu
		    stmt.executeUpdate(query);
            // Close the prepared statement
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();  // Handle any potential errors
        }
	}
	

}
