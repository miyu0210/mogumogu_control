package controllers.receipt;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Receipt;
import utils.DBUtil;

/**
 * Servlet implementation class ReceiptDestroyServlet
 */
@WebServlet("/receipt/destroy")
public class ReceiptDestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptDestroyServlet() {
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
            
            Receipt r = em.find(Receipt.class, (Integer)(request.getSession().getAttribute("receipt_id")));
            
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
            em.close();
            
            request.getSession().removeAttribute("receit_id");
            
            response.sendRedirect(request.getContextPath() + "/receipt/index");
        }
	}

}
