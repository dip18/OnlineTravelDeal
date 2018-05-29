package pro.dao;

import java.sql.*;

public class MerchantDAO
{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement validatePstmt;
	private String validateSql="SELECT MERNAME FROM MERLOGIN WHERE MERID=?";
	
	public MerchantDAO() 
			throws ClassNotFoundException,SQLException
	{

		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		validatePstmt=con.prepareStatement(validateSql);
	
	}
	
	
	
	public Merchant validate1(int merid) throws SQLException
	{
		validatePstmt.setInt(1,merid);
		
		ResultSet rs=validatePstmt.executeQuery();
		if(rs.next()){
			int merid1 = rs.getInt(merid);
			
			Merchant mer = new Merchant(merid1);
			return mer;
		}else{
			return null;
		}

	}

}
