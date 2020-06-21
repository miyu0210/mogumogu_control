package controllers.receipt;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DTotal;
import models.Receipt;
import models.Ttotal;
import utils.DBUtil;

/**
 * Servlet implementation class ReceiptDayTotalServlet
 */
@WebServlet("/receipt/daytotal")
public class ReceiptDayTotalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptDayTotalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("_token", request.getSession().getId());
        
        Receipt r = new Receipt();
        
        r.setReceipt_date(new Date(System.currentTimeMillis()));
        request.setAttribute("receipt", r);
	    
	    EntityManager em = DBUtil.createEntityManager();
	    
	    String today1 = request.getParameter("receipt_date");
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	    
	    LocalDate today2 = LocalDate.parse(today1, dtf);
	    
	    java.sql.Date today = java.sql.Date.valueOf(today2);
        
	    List<Ttotal> daytotal = em.createNamedQuery("AllReceiptDay", Ttotal.class)
	                                .setParameter("today", today)
	                                .getResultList();
	    
	    List<DTotal> d_total = em.createNamedQuery("SUMReceiptDay", DTotal.class)
                .setParameter("start", today)
                .setParameter("last", today)
                .getResultList();
	    
	    System.out.println(daytotal);
	    
	    em.close();
	    
	    request.setAttribute("daytotal", daytotal);
	    request.setAttribute("today", today);
	    request.setAttribute("d_total", d_total);
	            
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/receipt/daytotal.jsp");
        rd.forward(request, response);
	}

}
