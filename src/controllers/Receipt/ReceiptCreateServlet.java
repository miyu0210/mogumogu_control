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
 * Servlet implementation class ReceiptCreateServlet
 */
@WebServlet("/receipt/create")
public class ReceiptCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _token =(String)request.getParameter("_token");
		if(_token != null && _token.equals(request.getSession().getId())) {
		    EntityManager em = DBUtil.createEntityManager();
		    
		    Receipt r = new Receipt();
		    
		    Date receipt_date = new Date(System.currentTimeMillis());
		    String rd_str = request.getParameter("receipt_date");
		             if(rd_str != null && !rd_str.equals("")) {
		                 receipt_date = Date.valueOf(request.getParameter("receipt_date"));
		             }
		             r.setReceipt_date(receipt_date);
		             
		             r.setTotalamount(Integer.parseInt(request.getParameter("totalamount")));
		             r.setPayment(request.getParameter("payment"));
		             
		             Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		             r.setCreated_at(currentTime);
		             r.setUpdated_at(currentTime);
		             
		             em.getTransaction().begin();
		             em.persist(r);
		             em.getTransaction().commit();
		             em.close();
		             request.getSession().setAttribute("flush", " 登録完了");
		             
		             response.sendRedirect(request.getContextPath() + "/receipt/index");
		             
		            
		}
	}

}
