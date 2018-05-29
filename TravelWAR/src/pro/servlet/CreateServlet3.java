package pro.servlet;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.*;

/**
 * Servlet implementation class CreateServlet3
 */
@WebServlet("/CreateServlet3")
public class CreateServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet3() {
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
		String custid1 = request.getParameter("custid");
		int custid = Integer.parseInt(custid1);
		
		/*String offerid1 = request.getParameter("offerid");
		int offerid = Integer.parseInt(offerid1);*/
		
		RequestDispatcher rd2 = request.getRequestDispatcher("/confirm1.jsp");
		//RequestDispatcher rd3 = request.getRequestDispatcher("/allcust.jsp");
		
		try{
		CustOfferDAO dao = new CustOfferDAO();
		CustOffer co = dao.confirm(custid);
		
		//Collection <Customer> list = dao.show(offerid);
		
		request.setAttribute("CONFIRM", co);
		rd2.forward(request, response);
		
		/*if(list != null)
		{
			request.setAttribute("LIST", list);
			rd3.forward(request, response);
		}*/
		
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			//out.println("<b> CLASS LOADING PROBLEM:"+e.getMessage()+"</b>");
			//request.setAttribute("ERRMSG", "CLASS LOADING PROBLEM :"+e.getMessage());
			//rd.forward(request, response);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//out.println("<b> SQL PROBLEM:"+e.getMessage()+"</b>");
			//request.setAttribute("ERRMSG", "SQL PROBLEM :"+e.getMessage());
			//rd.forward(request, response);
		}
	}

}
