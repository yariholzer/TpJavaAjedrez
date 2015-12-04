package aim;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cpDatos.Piezas;
import cpLogica.CtrlAjedrez;

@WebServlet("/save")
public class Save  extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;

	public Save(){}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession se = request.getSession();
		
		// recarga la partida
		
		cpLogica.CtrlAjedrez ctrl = (cpLogica.CtrlAjedrez) se.getAttribute("Controlador");
		ctrl.guardarPartida();
		request.getRequestDispatcher("login.html").forward(request, response);
		
	}
}