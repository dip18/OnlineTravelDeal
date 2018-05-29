package pro.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.*;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cnfrm = request.getParameter("confirm");
		int cnfrm1 = Integer.parseInt(cnfrm);
		
		RequestDispatcher rd = request.getRequestDispatcher("/confirmation.jsp");
		//response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		try {
			CustOfferDAO dao = new CustOfferDAO();
			int cn = dao.cnfrmtn(cnfrm1);
			
			//out.println("<b> DEAL CONFIRMED </b>");
			
			if(cn >= 0)
			{
				request.setAttribute("CONFIRMATION", cn);
				rd.forward(request, response);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//out.close();
	}

}
