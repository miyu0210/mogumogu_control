package controllers.receipt;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DTotal;
import models.MTotal;
import utils.DBUtil;

/**
 * Servlet implementation class ReceiptMatomeServlet
 */
@WebServlet("/receipt/matome")
public class ReceiptMatomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final int MAKE_MONTHS = 2 * 12; // リストの数（過去３年分）
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptMatomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EntityManager em = DBUtil.createEntityManager();
        
        Integer startday = em.createNamedQuery("getStartday", Integer.class)
                              .getSingleResult();
	    
	    String selectMonth = request.getParameter("select_month");
	    LocalDate now = LocalDate.now();
	    LocalDate IdSelectMonth;
	    int selectedYear;
	    int selectedMonth;
	    
	    if(selectMonth == null || selectMonth.equals("")) {
	        selectedYear = now.getYear();
	        selectedMonth = now.getMonthValue();
	    } else {
	        selectedYear = LocalDate.parse(selectMonth).getYear();
	        selectedMonth = LocalDate.parse(selectMonth).getMonthValue();
	    }
	    IdSelectMonth = LocalDate.of(selectedYear, selectedMonth, startday);
	    
	    List<LocalDate> months = new ArrayList<>();
	    for(int i = 0; i < MAKE_MONTHS; i++) {
	        months.add(LocalDate.of(now.getYear(), now.getMonth(), startday).minusMonths(i));
	    }
	        request.setAttribute("months", months);
	        request.setAttribute("selected_month", IdSelectMonth);
	        
	        Object sd = request.getAttribute("selected_month");
	        System.out.println(sd);
	        
	        String sta = sd.toString();
	        System.out.println(sta);
	        
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        
	        LocalDate star = LocalDate.parse(sta, dtf);
	        System.out.println(star);
	        
	        java.sql.Date start = java.sql.Date.valueOf(star);
	        
	        LocalDate last1 = star.plusMonths(1);
	        LocalDate last2 = last1.minusDays(1);
	        
	        java.sql.Date last = java.sql.Date.valueOf(last2);
	        
	        
	        List<DTotal> d_total = em.createNamedQuery("SUMReceiptDay", DTotal.class)
	                                  .setParameter("start", start)
	                                  .setParameter("last", last)
	                                  .getResultList();
	        
	        List<MTotal> m_total = em.createNamedQuery("SUMReceiptMonth", MTotal.class)
                    .setParameter("start", start)
                    .setParameter("last", last)
                    .getResultList();

	      
	       
	       long receipt_total = (long)em.createNamedQuery("getReceiptTotal", Long.class)
	                                       .getSingleResult();
	       
	        em.close();
	       
	        request.setAttribute("_token", request.getSession().getId());	        
	        request.setAttribute("d_total", d_total);
	        request.setAttribute("receipt_total", receipt_total);
	        request.setAttribute("m_total", m_total);
	        
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/receipt/matome.jsp");
	        rd.forward(request, response);
	    
	}

}
