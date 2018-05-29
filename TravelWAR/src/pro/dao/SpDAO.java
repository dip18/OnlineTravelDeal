package pro.dao;

import java.sql.*;

public class SpDAO
{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement validatePstmt;
	private String validateSql="SELECT SPMAIL,SPPASS FROM SPLOGIN WHERE SPMAIL=? AND SPPASS=?";
	
	public SpDAO() 
			throws ClassNotFoundException,SQLException
	{

		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		validatePstmt=con.prepareStatement(validateSql);
	
	}
	
	public Sp validate(String spmail,String sppass) throws SQLException
	{
		validatePstmt.setString(1,spmail);
		validatePstmt.setString(2,sppass);
		ResultSet rs=validatePstmt.executeQuery();
		if(rs.next()){
			String spmail1 = rs.getString(1);
			String sppass1 = rs.getString(2);
			
			Sp sp = new Sp(spmail1,sppass1);
			return sp;
		}else{
			return null;
		}

	}
}
