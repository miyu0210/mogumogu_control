package controllers.budget;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Budget;
import utils.DBUtil;

/**
 * Servlet implementation class BudgetShowServlet
 */
@WebServlet("/budget/show")
public class BudgetShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BudgetShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();
	    
	    Budget b = em.find(Budget.class, Integer.parseInt(request.getParameter("id")));
	    em.close();
	    
	    request.setAttribute("budget", b);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/budget/show.jsp");
	    rd.forward(request, response);
	}

}
