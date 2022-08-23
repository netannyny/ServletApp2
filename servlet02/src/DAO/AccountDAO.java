package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scopedata.UserData2;

public class AccountDAO {
	public UserData2 findUserCheck( UserData2 login ) {
		UserData2 account;
		Connection con = null;
		PreparedStatement pstmt;
		String  id = login.getId();
		String pass = login.getPass();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test","sa","pass");
			String sql ="select * from account1 where id = ? and pass = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1 , id );
			pstmt.setString( 2 , pass );

			ResultSet rs = pstmt.executeQuery();

			boolean  b = rs.next();

			//System.out.println( "|" + pass +"|  |" + rs.getString("pass")+"|");

			if( b == false) {
				return null;
			}

			account = new UserData2( id , pass );
		}catch( Exception e ) {
			return null;
		}finally {
			 try {
				if( con !=null )		con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return account;
	}

}