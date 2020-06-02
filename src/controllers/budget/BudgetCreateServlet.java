package controllers.budget;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Budget;
import utils.DBUtil;

/**
 * Servlet implementation class BudgetCreateServlet
 */
@WebServlet("/budget/create")
public class BudgetCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BudgetCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = (String)request.getParameter("_token");
		if(_token != null && _token.equals(request.getSession().getId())) {
		    EntityManager em = DBUtil.createEntityManager();
		    
		    Budget b = new Budget();
		    
		    Integer budget = Integer.parseInt(request.getParameter("budget"));
		    b.setBudget(budget);
		    
		    String startday = request.getParameter("startday");
		    b.setStartday(startday);
		    
		    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		    b.setCreated_at(currentTime);
		    b.setUpdated_at(currentTime);
		    
		    em.getTransaction().begin();
		    em.persist(b);
		    em.getTransaction().commit();
		    em.close();
		    
		    response.sendRedirect(request.getContextPath() + "/budget/index");
		    
		    
		}
	}

}
