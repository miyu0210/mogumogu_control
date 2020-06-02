package controllers.Receipt;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Receipt;

/**
 * Servlet implementation class ReceiptNewServlet
 */
@WebServlet("/receipt/new")
public class ReceiptNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptNewServlet() {
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
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/receipt/new.jsp");
	    rd.forward(request, response);
	}

}
