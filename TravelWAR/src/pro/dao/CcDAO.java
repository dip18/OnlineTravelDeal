package pro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CcDAO {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement validatePstmt;
	private String validateSql="SELECT CCMAIL,CCPASS FROM CCLOGIN WHERE CCMAIL=? AND CCPASS=?";
	
	public CcDAO() 
			throws ClassNotFoundException,SQLException
	{

		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		validatePstmt=con.prepareStatement(validateSql);
	
	}
	
	public Cc validate(String ccmail,String ccpass) throws SQLException
	{
		validatePstmt.setString(1,ccmail);
		validatePstmt.setString(2,ccpass);
		ResultSet rs=validatePstmt.executeQuery();
		if(rs.next()){
			String ccmail1 = rs.getString(1);
			String ccpass1 = rs.getString(2);
			
			Cc cc = new Cc(ccmail1,ccpass1);
			return cc;
		}else{
			return null;
		}

	}
}
