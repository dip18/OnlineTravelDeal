package pro.servlet;

import java.io.*;
import java.sql.*;
import java.util.Collection;

import pro.dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class MerServlet
 */
@WebServlet("/MerServlet")
public class MerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerServlet() {
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
		String mermail = request.getParameter("mermail");
		String merpass = request.getParameter("merpass");
		
		RequestDispatcher rdsuccess = request.getRequestDispatcher("/merchant.jsp");
		RequestDispatcher rderror = request.getRequestDispatcher("/errror4.jsp");
		try
		{
			MerDAO dao = new MerDAO();
			Mer m = dao.validate(mermail, merpass);
			int merid = m.getMerid();
			String mername = m.getMername();
			Collection <Salesperson> list = dao.getoffer(merid);
			
			if(m != null){
				request.setAttribute("MER", m);
				//request.setAttribute("MERID",merid);
				request.setAttribute("MERNAME", mername);
				request.setAttribute("LIST", list);
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
