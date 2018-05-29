package pro.servlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import pro.dao.*;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
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
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		String strcustid=request.getParameter("custid");
		String strofferid=request.getParameter("offerid");
		
		RequestDispatcher rd = request.getRequestDispatcher("/buy.jsp");
		
		int intcustid = Integer.parseInt(strcustid);
		int intofferid = Integer.parseInt(strofferid);
		
		CustOffer co = new CustOffer(intcustid,intofferid);
		try {
			CustomerDAO dao = new CustomerDAO();
			int bk = dao.book(co);
			
			if(bk >= 0)
			{
				request.setAttribute("BOOK", bk);
				rd.forward(request, response);
			}
			
			//out.println("<b>YOUR REQUEST HAS BEEN RECEIVED.....<b>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
