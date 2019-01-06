package br.com.wagner.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.wagner.model.UsuarioDAO;
import br.com.wagner.persistencia.Usuario;

@WebServlet("/usuarioServlet.do")
public class UsuarioServlet extends HttpServlet {
	public UsuarioServlet() {
		System.out.println("Reposta do construtor");

	}

	@Override
	public void init() throws ServletException {
		System.out.println("Resposta do medtodo incializador");
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Teste do Get Ok");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("teste do Post Ok");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("Teste do método Post Ok");
	}

	/**
	 * String nome = request.getParameter("nome"); String login =
	 * request.getParameter("login"); String senha = request.getParameter("senha");
	 * String id = request.getParameter("id");
	 * 
	 * Usuario usuario = new Usuario(); usuario.setNome(nome);
	 * usuario.setLogin(login); usuario.setSenha(senha); Integer codigo =
	 * Integer.parseInt(id); usuario.setId(codigo);
	 * 
	 * UsuarioDAO udao = new UsuarioDAO();
	 * 
	 * udao.createUsuario(usuario); udao.alterarUsuario(usuario);
	 * response.getWriter().println("
	 * <h1>usuario cadastrado com sucesso</h1>"); }
	 **/
}