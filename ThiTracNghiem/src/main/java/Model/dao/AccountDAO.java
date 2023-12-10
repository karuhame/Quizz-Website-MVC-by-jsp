package Model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.bean.*;


public class AccountDAO {

	public int checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		try {
       
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("SELECT ID_Account FROM account WHERE username ='"+username+"' AND password ='"+ password+"'");
            int id;
            if(rs.next()){
                id = rs.getInt("ID_Account");
                return id;
                
            }
            conn.close();
            st.close();
            rs.close();
            
        } catch (Exception e) {
        }
		return -1;
	}
	
	public int getRoleByID(int ID) {
		try {
		       
            Connection conn  = new ConnectionJDBC().getConn();
            Statement  st = conn.createStatement();
            ResultSet  rs = st.executeQuery("SELECT role FROM account WHERE ID_Account ="+ID);
            int id;
            if(rs.next()){
                id = rs.getInt("role");
                return id;
                
            }
            conn.close();
            st.close();
            rs.close();
            
        } catch (Exception e) {
        }
		return -1;
		
	}

	public void Logout() {
		// TODO Auto-generated method stub
		
	}
	public void updatePassword(int ID_Account, String newPass) {
		try {
		       
            Connection conn  = new ConnectionJDBC().getConn();
            String query = "UPDATE account SET password = ? WHERE ID_Account = ?";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    
		    // Gán các giá trị cho các tham số trong câu lệnh truy vấn
		    stmt.setString(1, newPass);
		    stmt.setInt(2, ID_Account);  
		   
		    // Thực thi câu lệnh truy vấn để cập nhật thông tin vacxin trong cơ sở dữ liệu
		    stmt.executeUpdate();

            // Close the prepared statement
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	public List<AccountBEAN> getAllAccount(){
		List<AccountBEAN> list = new ArrayList();
		try {
			String sql = "SELECT *" +
                    "FROM account";
                    
            Connection conn  = new ConnectionJDBC().getConn();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
	
			while (resultSet.next()) {
				int ID_Account = resultSet.getInt("ID_Account");
				int role = resultSet.getInt("role");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				
				AccountBEAN sv = new AccountBEAN(ID_Account,username,password,role );
				list.add(sv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
 
	
}
