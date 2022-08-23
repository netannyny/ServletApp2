package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scopedata.UserData;

public class RegisterDAO {
	public int execute(UserData account){
		int f = 0;
		Connection con = null;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/test","sa","pass");
			String sql = "insert into account1 values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,account.getId());
			pstmt.setString(2,account.getPass());
			pstmt.setString(3,account.getName());
			f = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return f;
	}
}