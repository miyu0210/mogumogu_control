package controllers.receipt;

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
 * Servlet implementation class ReceiptTotalServlet
 */
@WebServlet("/receipt/total")
public class ReceiptTotalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptTotalServlet() {
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
	    
	    long receipt_total = (long)em.createNamedQuery("getReceiptTotal", Long.class)
                                        .getSingleResult();
	    
	    em.close();
	    
	    request.setAttribute("reseipt", receipt);
	    request.setAttribute("receipt_total", receipt_total);
	    
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/receipt/index.jsp");
	    rd.forward(request, response);
	}

}
