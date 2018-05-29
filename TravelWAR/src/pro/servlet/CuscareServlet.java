package pro.servlet;

import java.io.IOException;
import java.sql.SQLException;

import pro.dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pro.dao.Customer;

/**
 * Servlet implementation class CuscareServlet
 */
@WebServlet("/CuscareServlet")
public class CuscareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuscareServlet() {
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
		String strcname1 = request.getParameter("cname1");
		String strcmail1 = request.getParameter("cmail1");
		
		
		
		RequestDispatcher rd3 = request.getRequestDispatcher("/customer1.jsp");
		
		
		try {
			CustomerDAO dao;
			dao = new CustomerDAO();
			
			Customer cust2 = dao.cuscare(strcname1, strcmail1);
			if(cust2 != null) {
				request.setAttribute("CUST2", cust2);
				rd3.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
