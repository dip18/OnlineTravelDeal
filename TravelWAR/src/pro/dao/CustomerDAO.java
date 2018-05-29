package pro.dao;
import java.sql.*;
import java.util.*;
public class CustomerDAO
{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement createPstmt,searchPstmt,bookPstmt,retcustidPstmt,viewPstmt,cuscarePstmt;
	
	private String createSql="INSERT INTO CLOGIN(CNAME,CMAIL,CPASS) VALUES (?,?,?)";
	private String searchSql="SELECT OFFERID,DESCRIPTION,PRICE,VALIDFROM,VALIDTO FROM OFFER WHERE PRICE >= ?";
	private String retcustidSql="SELECT CUSTID FROM CLOGIN WHERE CNAME=? AND CMAIL=? AND CPASS=?";
	private String bookSql = "INSERT INTO CUSTOFFER(CUSTID,OFFERID,STATUS) VALUES(?,?,0)";
	private String viewSql = "SELECT DESCRIPTION,PRICE,VALIDFROM,VALIDTO FROM OFFER WHERE OFFERID IN (SELECT OFFERID FROM CUSTOFFER WHERE CUSTID=?)";
	//private String confirmSql = "SELECT STATUS FROM CUSTOFFER WHERE CUSTID=?";
	private String cuscareSql="SELECT CNAME,CMAIL FROM CLOGIN WHERE CNAME=? AND CMAIL=?";
	
	
	public CustomerDAO()throws ClassNotFoundException,SQLException
	{
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		createPstmt=con.prepareStatement(createSql);
		searchPstmt=con.prepareStatement(searchSql);
		bookPstmt=con.prepareStatement(bookSql);
		retcustidPstmt = con.prepareStatement(retcustidSql);
		viewPstmt=con.prepareStatement(viewSql);
		//confirmPstmt = con.prepareStatement(confirmSql);
		cuscarePstmt = con.prepareStatement(cuscareSql);
	}
	
	public void create(Customer c) throws SQLException
	{
		
		createPstmt.setString(1,c.getCname());
		createPstmt.setString(2,c.getCmail());
		createPstmt.setString(3,c.getCpass());
		
		createPstmt.executeUpdate();
			
	}

	public Collection<Salesperson> search(int pr) throws SQLException
	{
		searchPstmt.setInt(1,pr);
		ResultSet rs= searchPstmt.executeQuery();
		ArrayList<Salesperson> l = null;
		
		while(rs.next())
		{
			if(l == null)
			{
				l = new ArrayList<Salesperson>(); 
			}
				int offerid = rs.getInt(1);
				String desc = rs.getString(2);
				int price1 = rs.getInt(3);
				String valfrm = rs.getString(4);
				String valto = rs.getString(5);
			
				Salesperson sp = new Salesperson(offerid,desc,price1,valfrm,valto);
				l.add(sp);
				
		System.out.println("=================================="+l);
		
		}
		return l;
	}
	
	public Customer retcustid(String cname,String cmail,String cpass) throws SQLException
	{
		retcustidPstmt.setString(1, cname);
		retcustidPstmt.setString(2, cmail);
		retcustidPstmt.setString(3, cpass);
		
		ResultSet rs = retcustidPstmt.executeQuery();
		if(rs.next())
		{
				int custid = rs.getInt(1);	

				Customer cust = new Customer(custid);
				return cust;
		}else{
			return null;
		}
		
	}
	public int book(CustOffer co) throws SQLException
	{
		bookPstmt.setInt(1, co.getCustid());
		bookPstmt.setInt(2, co.getOfferid());
		
		int bk=bookPstmt.executeUpdate();
		return bk;
		
	}
	
	public Collection <Salesperson> view(int custid) throws SQLException
	{
		viewPstmt.setInt(1, custid);
		ResultSet rs = viewPstmt.executeQuery();
		ArrayList<Salesperson> l = null;
		
		while(rs.next())
		{
			if(l == null)
			{
				l = new ArrayList<Salesperson>(); 
			}
				String description = rs.getString(1);
				int price = rs.getInt(2);
				String validfrom = rs.getString(3);
				String validto = rs.getString(4);
			
				Salesperson sp = new Salesperson(description,price,validfrom,validto);
				l.add(sp);
		}
		return l;
		
	}
	
	/*public CustOffer confirm(int custid) throws SQLException
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
	}*/
	
	public Customer cuscare(String cname,String cmail) throws SQLException
	{
		cuscarePstmt.setString(1, cname);
		cuscarePstmt.setString(2, cmail);
		
		ResultSet rs = cuscarePstmt.executeQuery();
		
		if(rs.next())
		{
			String cname1=rs.getString(1);
			String cmail1=rs.getString(2);
			
			Customer cust = new Customer(cname1,cmail1);
			return cust;
		}else{
			return null;
		}
		
	}
}

