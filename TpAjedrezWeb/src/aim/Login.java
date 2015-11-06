package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cpLogica.CtrlAjedrez;

@WebServlet("/login")
public class Login  extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	public Login(){}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cpLogica.CtrlAjedrez ctrl = new CtrlAjedrez();
		
		Long dniJugadorBlancas 			=Long.parseLong(request.getParameter("DniBlancas"));
		String ApellidoJugadorBlancas 	=request.getParameter("ApellidoBlancas");
		String NombreJugadorBlancas 	=request.getParameter("NombreBlancas");
		
		Long dniJugadorNegras			=Long.parseLong(request.getParameter("DniNegras"));
		String ApellidoJugadorNegras 	=request.getParameter("ApellidoNegras");
		String NombreJugadorNegras 		=request.getParameter("NombreNegras");
		
		String[] datosJugadorBlancas = new String[2];
		String[] datosJugadorNegras  = new String[2];
		
		datosJugadorBlancas = ctrl.recDatosJugador(dniJugadorBlancas);
		datosJugadorNegras  = ctrl.recDatosJugador(dniJugadorNegras);
		
		
		request.setAttribute("Dni1", "123");
		request.getRequestDispatcher("redirected.jsp").forward(request, response);
	}

	
}
