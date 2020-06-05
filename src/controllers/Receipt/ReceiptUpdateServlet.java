package controllers.receipt;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Receipt;
import utils.DBUtil;

/**
 * Servlet implementation class ReceiptUpdateServlet
 */
@WebServlet("/receipt/update")
public class ReceiptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptUpdateServlet() {
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
		    
		    r.setReceipt_date(Date.valueOf(request.getParameter("receipt_date")));
		    r.setTotalamount(Integer.parseInt(request.getParameter("totalamount")));
		    r.setPayment(request.getParameter("payment"));
		    r.setUpdated_at(new Timestamp(System.currentTimeMillis()));
		    
		    em.getTransaction().begin();
		    em.getTransaction().commit();
		    em.close();
		    request.getSession().setAttribute("flush", "登録完了");
		    
		    request.getSession().removeAttribute("receipt_id");
		    
		    response.sendRedirect(request.getContextPath() + "/receipt/index");
		}
	}

}
