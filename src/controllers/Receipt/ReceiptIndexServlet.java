package controllers.receipt;

import java.io.IOException;
import java.sql.Date;
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

import models.Budget;
import models.DTotal;
import models.MTotal;
import models.Receipt;
import utils.DBUtil;

/**
 * Servlet implementation class ReceiptIndexServlet
 */
@WebServlet("/receipt/index")
public class ReceiptIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private static final int MAKE_MONTHS = 3 * 12; // リストの数（過去３年分）
	
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
	    if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }
        
	    request.setAttribute("_token", request.getSession().getId());
        
        Receipt r = new Receipt();
        
        r.setReceipt_date(new Date(System.currentTimeMillis()));
        request.setAttribute("receipt", r);
	    
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

        Integer budget = em.createNamedQuery("getBudget", Integer.class)
                            .getSingleResult();
        
        List<Budget> id = em.createNamedQuery("getAllBudget", Budget.class)
                            .getResultList();

        em.close();

        request.setAttribute("d_total", d_total);
        request.setAttribute("m_total", m_total);
        request.setAttribute("budget", budget);
        request.setAttribute("startday", startday);
        request.setAttribute("budget_id", id);
        
        System.out.println(budget + ":" + startday);
        
        Integer bg = (Integer)(request.getAttribute("budget"));
        System.out.println(bg);
        
        @SuppressWarnings("unchecked")
        List<MTotal> mt = (List<MTotal>)(request.getAttribute("m_total"));
        MTotal mtt = mt.get(0);
        System.out.println(mtt.getSumM());
        
        long zan = bg - mtt.getSumM();
        System.out.println(zan);
        
        request.setAttribute("zan", zan);
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/receipt/index.jsp");
        rd.forward(request, response);
	    
	    
	}

}
