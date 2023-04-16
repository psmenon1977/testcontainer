package com.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String GREETING_REQUEST_PARAMETER_KEY = "greeting";
    private static final String NAME_REQUEST_PARAMETER_KEY = "name";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
	            throws ServletException, IOException {
	 
	        handleRequestForGreeting(req, resp);
	    }
	 
	    private void handleRequestForGreeting(final HttpServletRequest req, final HttpServletResponse resp)
	            throws ServletException, IOException {
	        assert !Objects.isNull(req) : "Request required for greeting request";
	        assert !Objects.isNull(resp) : "Response required for greeting request";
	 
	        final String name = extractNameFromRequest(req);
	        final String greeting = greet(name);
	        System.out.println("inside HelloWorldServlet.......");
	        req.setAttribute(GREETING_REQUEST_PARAMETER_KEY, greeting);
	        req.getRequestDispatcher("/jsp/greeting.jsp").forward(req, resp);
	    }
	    
	    
	    private String extractNameFromRequest(final HttpServletRequest req) {
	        assert !Objects.isNull(req) : "Request required for name extraction";
	 
	        return req.getParameter(NAME_REQUEST_PARAMETER_KEY);
	    }
	 
	    private String greet(final String name) {
	        assert !Objects.isNull(name) && !name.isEmpty() : "Name required for greeting";
	 
	        return String.format("Hello %s, the date on the server is %s", name, LocalDate.now());
	    } 
	    

}
