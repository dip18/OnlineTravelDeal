package pro.dao;
import java.sql.*;

public class SalespersonDAO
{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/PROJECT1";
	String user="root";
	String password="root123";
	
	private Connection con;
	private PreparedStatement createPstmt;
	
	private String createSql="INSERT INTO OFFER(DESCRIPTION,PRICE,VALIDFROM,VALIDTO,MERCHANTID) VALUES (?,?,?,?,?)";
	
	public SalespersonDAO()throws ClassNotFoundException,SQLException
	{
		Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		createPstmt=con.prepareStatement(createSql);
	}
	
	public int create(Salesperson sp) throws SQLException
	{
		
		createPstmt.setString(1,sp.getDescription());
		createPstmt.setInt(2,sp.getPrice());
		createPstmt.setString(3,sp.getValidfrom());
		createPstmt.setString(4,sp.getValidto());
		createPstmt.setInt(5,sp.getMerchantid());
		int sp1 = createPstmt.executeUpdate();
		return sp1;
			
	}

	
}
