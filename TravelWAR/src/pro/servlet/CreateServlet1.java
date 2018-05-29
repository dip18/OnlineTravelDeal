//FOR LOGIN NEW CUSTOMER


package pro.servlet;

import pro.dao.*;

import java.sql.*;
import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class CreateServlet1
 */
@WebServlet("/CreateServlet1")
public class CreateServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet1() {
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
		
		String strcname = request.getParameter("cname");
		String strcmail = request.getParameter("cmail");
		String strcpass = request.getParameter("cpass");
		
		
		
		Customer c = new Customer(strcname,strcmail,strcpass);
		//Customer cust1 = new Customer(strcname1,strcmail1);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/offer.jsp");
		//RequestDispatcher rd2 = request.getRequestDispatcher("/confirm1.jsp");
		
		
		
		try
		{
			CustomerDAO dao = new CustomerDAO();
			dao.create(c);
			
			Customer cust=dao.retcustid(strcname, strcmail, strcpass);
			//int custid = cust.getCustid();
			
			Collection <Salesperson> list = dao.search(0) ;
			//Collection <Salesperson> list1 = dao.view(custid);
			
			
			//String custid1 = request.getParameter("custid");
			//int custid2 = Integer.parseInt(custid1);
			//CustOffer co = dao.confirm(custid2);
			
			if(list != null)
			{
				request.setAttribute("LIST", list);
				request.setAttribute("CUST", cust);
				rd.forward(request, response);
			}
			
			//if(list1 != null)
			//{
				//request.setAttribute("VIEW", list1);
				//request.setAttribute("CONFIRM", co);
				//rd2.forward(request, response);
			//}
				
				
		
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			//out.println("<b> CLASS LOADING PROBLEM:"+e.getMessage()+"</b>");
			request.setAttribute("ERRMSG", "CLASS LOADING PROBLEM :"+e.getMessage());
			rd.forward(request, response);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//out.println("<b> SQL PROBLEM:"+e.getMessage()+"</b>");
			request.setAttribute("ERRMSG", "SQL PROBLEM :"+e.getMessage());
			rd.forward(request, response);
		}
		
		//out.close();

		
	}

}
