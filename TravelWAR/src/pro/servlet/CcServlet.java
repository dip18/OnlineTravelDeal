package pro.servlet;

import java.io.*;
import java.sql.*;

import pro.dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class CcServlet
 */
@WebServlet("/CcServlet")
public class CcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CcServlet() {
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
		String ccmail = request.getParameter("ccmail");
		String ccpass = request.getParameter("ccpass");
		
		RequestDispatcher rdsuccess = request.getRequestDispatcher("/customercare1.html");
		RequestDispatcher rderror = request.getRequestDispatcher("/error1.jsp");
		try
		{
			CcDAO dao = new CcDAO();
			Cc cc = dao.validate(ccmail, ccpass);
			if(cc != null){
				request.setAttribute("CC", cc);
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
