package pro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MerDAO {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement validatePstmt,getofferPstmt;
	private String validateSql="SELECT  MERMAIL,MERPASS,MERID,MERNAME FROM MERLOGIN WHERE MERMAIL=? AND MERPASS=?";
	private String getofferSql="SELECT OFFERID,DESCRIPTION,PRICE,VALIDFROM,VALIDTO FROM OFFER WHERE MERCHANTID=?";
	
	public MerDAO() 
			throws ClassNotFoundException,SQLException
	{

		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		validatePstmt = con.prepareStatement(validateSql);
		getofferPstmt = con.prepareStatement(getofferSql);
		
	
	}
	
	public Mer validate(String mermail,String merpass) throws SQLException
	{
		validatePstmt.setString(1,mermail);
		validatePstmt.setString(2,merpass);
		ResultSet rs=validatePstmt.executeQuery();
		if(rs.next()){
			String mermail1 = rs.getString(1);
			String merpass1 = rs.getString(2);
			int merid1 = rs.getInt(3);
			String mername1 = rs.getString(4);
		
			Mer m = new Mer(mermail1,merpass1);
			m.setMerid(merid1);
			m.setMername(mername1);
			
			return m;
		}else{
			return null;
		}

	}
	
	public Collection<Salesperson> getoffer(int merchantid) throws SQLException 
	{
		getofferPstmt.setInt(1, merchantid);
		ResultSet rs = getofferPstmt.executeQuery();
		
ArrayList<Salesperson> l = null;
		
		while(rs.next())
		{
			if(l == null)
			{
				l = new ArrayList<Salesperson>(); 
			}
				int offerid = rs.getInt(1);
				String description = rs.getString(2);
				int price = rs.getInt(3);
				String validfrom = rs.getString(4);
				String validto = rs.getString(5);
				
				Salesperson sp = new Salesperson(offerid,description,price,validfrom,validto);
				l.add(sp);
		}
		
			return l;
		
			
		
	}
}
