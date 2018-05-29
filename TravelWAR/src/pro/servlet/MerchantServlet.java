package pro.servlet;

import java.io.*;
import java.sql.*;

import pro.dao.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class MerchantServlet
 */
@WebServlet("/MerchantServlet")
public class MerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerchantServlet() {
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
		
		String merid = request.getParameter("merid");
		int intmerid =Integer.parseInt(merid); 
		
		RequestDispatcher rd = request.getRequestDispatcher("/merchant.jsp");
		try{
		MerchantDAO dao = new MerchantDAO();
		Merchant mer = dao.validate1(intmerid);
		
		request.setAttribute("MERCHANT", mer);
		rd.forward(request, response);
		}catch(ClassNotFoundException e){
			e.printStackTrace();

			//request.setAttribute("ERRMSG","Class Loading Error "+e.getMessage());
			//rderror.forward(request, response);
		}catch(SQLException e){
			e.printStackTrace();

			//request.setAttribute("ERRMSG","SQL Error "+e.getMessage());
			//rderror.forward(request, response);
		}
	
		
	}

}
