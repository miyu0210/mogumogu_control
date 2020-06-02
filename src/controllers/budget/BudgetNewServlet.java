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
 * Servlet implementation class BudgetNewServlet
 */
@WebServlet("/budget/new")
public class BudgetNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BudgetNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();
	    em.getTransaction().begin();
	    
	    Budget b = new Budget();
	    
	    Integer budget = 40000;
	    b.setBudget(budget);
	    
	    String startday = "1";
	    b.setStartday(startday);
	    
	    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	    b.setCreated_at(currentTime);
	    b.setUpdated_at(currentTime);
	    
	    em.persist(b);
	    em.getTransaction().commit();
	    
	    response.getWriter().append(Integer.valueOf(b.getId()).toString());
	    
	    em.close();
	}

}
