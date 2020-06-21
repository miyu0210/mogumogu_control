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
 * Servlet implementation class BudgetUpdateServlet
 */
@WebServlet("/budget/update")
public class BudgetUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BudgetUpdateServlet() {
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
		    
		    Budget b = em.find(Budget.class, (Integer)(request.getSession().getAttribute("budget_id")));
		    
		    b.setBudget(Integer.parseInt(request.getParameter("budget")));
		    b.setStartday(Integer.parseInt(request.getParameter("startday")));
		    b.setUpdated_at(new Timestamp(System.currentTimeMillis()));
		    
		    em.getTransaction().begin();
		    em.getTransaction().commit();
		    em.close();
		    request.getSession().setAttribute("flush", "更新完了");
		    
		    request.getSession().removeAttribute("budget_id");
		    
		    response.sendRedirect(request.getContextPath() + "/receipt/index");
		}
	}
}
