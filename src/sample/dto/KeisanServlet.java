package sample.dto;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtil;

/**
 * Servlet implementation class KeisanServlet
 */
@WebServlet("/keisan")
public class KeisanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeisanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("keisan/html; charset=UTF-8");
	    
	    EntityManager em = DBUtil.createEntityManager();
	    
	    List<Keisan> keisan = em.createQuery(
	            "select new sample.dto.Keisan(r.receipt_date, r.totalamount))"
	            + " from Receipt r group by r",Keisan.class).getResultList();
	    
	    for(Keisan k : keisan) {
	        System.out.println(k.getM_total());
	    }
	    
	    em.close();
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/receipt/daytotal.jsp");
        rd.forward(request, response);
	}

}
