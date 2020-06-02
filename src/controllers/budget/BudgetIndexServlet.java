package controllers.budget;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Budget;
import utils.DBUtil;

/**
 * Servlet implementation class BudgetIndexServlet
 */
@WebServlet("/budget/index")
public class BudgetIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BudgetIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();
	    
	    List<Budget> budget = em.createNamedQuery("getAllBudget", Budget.class)
	                            .getResultList();
	    response.getWriter().append(Integer.valueOf(budget.size()).toString());
	    
	    em.close();
	}

}
