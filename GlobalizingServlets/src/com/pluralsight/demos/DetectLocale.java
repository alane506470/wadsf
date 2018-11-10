package com.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetectLocale
 */
@WebServlet("/DetectLocale")
public class DetectLocale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetectLocale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		Locale locale=request.getLocale();
		String language=locale.getLanguage();
		String country=locale.getCountry();
		String displayCountry=locale.getDisplayCountry();
		String displaylanguage=locale.getDisplayLanguage();
		String displayName=locale.getDisplayName();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Greetings </title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<p>Language:"+language+"</p>");
		out.println("<p>Display Language:"+displaylanguage+"</p>");
		out.println("<p>Country : "+country+"</p>");
		out.println("<p>Display Country : "+displayCountry+"</p>");
		out.println("<p>Display Name : "+displayName+"</p>");
		
		Locale []availableLocale=Locale.getAvailableLocales();
		for(Locale aLocale:availableLocale) {
			out.println("<p>Name of locale :"+aLocale.getDisplayName()+"</p>");
			out.println("<p>Language Code: "+aLocale.getLanguage()+",Language Display Name: "+aLocale.getDisplayLanguage()+"</p>");
			out.println("<p>Country Code : "+aLocale.getCountry()+",Country Display Name:"+aLocale.getDisplayCountry()+"</p>");
		
			
		}
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
