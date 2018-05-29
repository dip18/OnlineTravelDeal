package pro.servlet;

import java.io.*;
import java.sql.*;
import pro.dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ExcustServlet
 */
@WebServlet("/ExcustServlet")
public class ExcustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcustServlet() {
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
		String cmail = request.getParameter("cmail");
		String cpass = request.getParameter("cpass");
		
		RequestDispatcher rdsuccess = request.getRequestDispatcher("/customer1.jsp");
		RequestDispatcher rderror = request.getRequestDispatcher("/error3.jsp");
		try
		{
			ExcustDAO dao = new ExcustDAO();
			Excust ec = dao.validate(cmail, cpass);
			if(ec != null){
				request.setAttribute("EC", ec);
				rdsuccess.forward(request, response);
			}else{
				request.setAttribute("ERRMSG", "INVALID EMAIL OR PASSWORD");
				rderror.forward(request, response);
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

			request.setAttribute("ERRMSG","Class Loading Error "+e.getMessage());
			rderror.forward(request, response);
		}catch(SQLException e){
			e.printStackTrace();

			request.setAttribute("ERRMSG","SQL Error "+e.getMessage());
			rderror.forward(request, response);
		}
		
	}

}
