package controllers.user;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.DBUtil;

/**
 * Servlet implementation class UserDestroyServlet
 */
@WebServlet("/user/destroy")
public class UserDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token = (String)request.getParameter("_token");
		if(_token != null && _token.equals(request.getSession().getId())){
		    EntityManager em = DBUtil.createEntityManager();
		    
		    User u = em.find(User.class, (Integer)(request.getSession().getAttribute("user_id")));
		    u.setUpdated_at(new Timestamp(System.currentTimeMillis()));
		    
		    em.getTransaction().begin();
		    em.remove(u);
		    em.getTransaction().commit();
		    em.close();
		    request.getSession().removeAttribute("user_id");
		    
		    response.sendRedirect(request.getContextPath() + "/user/index");
		}
	}

}
