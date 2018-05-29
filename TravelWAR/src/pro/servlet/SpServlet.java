package pro.servlet;
import pro.dao.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SpServlet
 */
@WebServlet("/SpServlet")
public class SpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpServlet() {
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
		String spmail = request.getParameter("spmail");
		String sppass = request.getParameter("sppass");
		
		RequestDispatcher rdsuccess = request.getRequestDispatcher("/salesperson1.html");
		RequestDispatcher rderror = request.getRequestDispatcher("/error2.jsp");
		try
		{
			SpDAO dao = new SpDAO();
			Sp sp = dao.validate(spmail, sppass);
			if(sp != null){
				request.setAttribute("SP", sp);
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
