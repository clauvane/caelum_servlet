package br.caelum.clauvane.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6515207490093942592L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("Primeira Servlet");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("Hello World!");
		out.print("</body>");
		out.print("</html>");
	}

}
