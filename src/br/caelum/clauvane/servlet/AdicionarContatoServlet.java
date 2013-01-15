package br.caelum.clauvane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.caelum.clauvane.dao.ContatoDao;
import br.caelum.clauvane.modelo.Contato;

public class AdicionarContatoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8523100058889735740L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("inicializando servlet...");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		log("finalizando servlet.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		service(req, resp);
		log("method GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		service(req, resp);
		log("method POST");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		
		Calendar data = null;
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
			data = Calendar.getInstance();
			data.setTime(d);
			contato.setDataNascimento(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ContatoDao dao = new ContatoDao();
		dao.addContato(contato);
		
		out.print("<html>");
		out.print("<head>");	
		out.print("<title>Apostila caelum fj212 - servlet</title>");
		out.print("</head>");
		out.println("<hr/>");
		out.print("<body>");
		out.print("<h3>");
		out.print("O contato "+contato.getNome());
		out.print("<br/>");
		out.print("foi adicionado com sucesso!");
		out.print("</h3>");
		out.print("</body>");
		out.print("</html>");
	}

}
