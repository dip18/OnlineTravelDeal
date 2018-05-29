package pro.dao;

import java.sql.*;
import java.util.*;

public class CustOfferDAO {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement confirmPstmt,showPstmt,cnfrmtnPstmt;
	
	private String confirmSql = "SELECT STATUS FROM CUSTOFFER WHERE CUSTID=?";
	private String showSql = "SELECT CUSTID,CNAME FROM CLOGIN WHERE CUSTID IN (SELECT CUSTID FROM CUSTOFFER WHERE OFFERID=?)";
	private String cnfrmtnSql = "UPDATE CUSTOFFER SET STATUS=1 WHERE CUSTID=?";
	
	
	public CustOfferDAO()throws ClassNotFoundException,SQLException
	{
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		confirmPstmt = con.prepareStatement(confirmSql);
		showPstmt = con.prepareStatement(showSql);
		cnfrmtnPstmt = con.prepareStatement(cnfrmtnSql);
	}
	
	public CustOffer confirm(int custid) throws SQLException
	{
		confirmPstmt.setInt(1, custid);
		ResultSet rs = confirmPstmt.executeQuery();
		if(rs.next())
		{
			int status = rs.getInt(1);
			
			CustOffer co = new CustOffer(status);
			return co;
		}else{
			return null;
		}
	}
	
	public Collection <Customer> show(int offerid) throws SQLException {
		showPstmt.setInt(1, offerid);
		ResultSet rs = showPstmt.executeQuery();
		ArrayList <Customer> list = null;
		
		while(rs.next())
		{
			if(list == null)
			{
				list = new ArrayList <Customer>();
				
			}
			int custid = rs.getInt(1);
			String cname = rs.getString(2);
			
			Customer cust = new Customer(custid,cname);
			list.add(cust);
		}
		return list;
	}

	public int cnfrmtn(int custid) throws SQLException {
		cnfrmtnPstmt.setInt(1, custid);
		int uc = cnfrmtnPstmt.executeUpdate();
		return uc;
	}
}

