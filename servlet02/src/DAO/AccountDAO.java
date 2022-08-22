package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scopedata.UserData;

public class AccountDAO {
	public UserData findUserCheck( UserData login ) {
		UserData account;
		Connection con = null;
		PreparedStatement pstmt;
		String  id = login.getId();
		String pass = login.getPass();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/test","sa","pass");
			String sql ="select * from account where id = ? and pass = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1 , id );
			pstmt.setString( 2 , pass );

			ResultSet rs = pstmt.executeQuery();

			rs.next();

			String name = rs.getString( "name" );
			account = new UserData( id , pass , name );

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