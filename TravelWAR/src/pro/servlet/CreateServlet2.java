package pro.servlet;

import pro.dao.*;

import java.sql.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class CreateServlet2
 */
@WebServlet("/CreateServlet2")
public class CreateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		String strdescription = request.getParameter("description");
		String strprice = request.getParameter("price");
		String strvalidfrom = request.getParameter("validfrom");
		String strvalidto = request.getParameter("validto");
		String strmerchantid = request.getParameter("merchantid");
		
		int price=Integer.parseInt(strprice);
		int merchantid=Integer.parseInt(strmerchantid);
		
		Salesperson sp = new Salesperson(strdescription,price,strvalidfrom,strvalidto,merchantid);
		
		//response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/dealadd.jsp");
		
		try
		{
			SalespersonDAO dao = new SalespersonDAO();
			int sp1 = dao.create(sp);
			
			if(sp1 >=0)
			{
				request.setAttribute("SP1", sp1);
				rd.forward(request, response);
			}
			
			
			//out.println("<b> DEAL ADDED........</b>");
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			//out.println("<b> CLASS LOADING PROBLEM:"+e.getMessage()+"</b>");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//out.println("<b> SQL PROBLEM:"+e.getMessage()+"</b>");
		
		}
		
		//out.close();

		
	}

}
