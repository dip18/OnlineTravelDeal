package pro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcustDAO {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement validatePstmt;
	private String validateSql="SELECT CMAIL,CPASS FROM CLOGIN WHERE CMAIL=? AND CPASS=?";
	
	public ExcustDAO() 
			throws ClassNotFoundException,SQLException
	{

		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		validatePstmt=con.prepareStatement(validateSql);
	
	}
	
	public Excust validate(String cmail,String cpass) throws SQLException
	{
		validatePstmt.setString(1,cmail);
		validatePstmt.setString(2,cpass);
		ResultSet rs=validatePstmt.executeQuery();
		if(rs.next()){
			String cmail1 = rs.getString(1);
			String cpass1 = rs.getString(2);
			
			Excust ec = new Excust(cmail1,cpass1);
			return ec;
		}else{
			return null;
		}

	}
}
