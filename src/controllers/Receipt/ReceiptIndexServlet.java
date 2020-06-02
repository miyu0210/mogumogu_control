package controllers.Receipt;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Receipt;
import utils.DBUtil;

/**
 * Servlet implementation class ReceiptIndexServlet
 */
@WebServlet("/receipt/index")
public class ReceiptIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();
	    
	    List<Receipt> receipt = em.createNamedQuery("getAllReceipt", Receipt.class)
	                               .getResultList();
	    response.getWriter().append(Integer.valueOf(receipt.size()).toString());
	    
	    em.close();
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/receipt/index.jsp");
	    rd.forward(request, response);
	}

}
