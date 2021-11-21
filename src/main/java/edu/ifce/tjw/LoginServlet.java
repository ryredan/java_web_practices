package edu.ifce.tjw;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeUsuario = request.getParameter("usuario");
		String senhaUsuario = request.getParameter("senha");

		if (nomeUsuario.equals("admin") && senhaUsuario.equals("123")){
			request.getSession().setAttribute("usuario", nomeUsuario);
			response.sendRedirect("email.jsp");
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("formlogin.html");
			dispatcher.forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("formLogin.html");
	}


}
