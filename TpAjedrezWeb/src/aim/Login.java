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
		String apellidoJugadorBlancas 	=request.getParameter("ApellidoBlancas");
		String nombreJugadorBlancas 	=request.getParameter("NombreBlancas");
		
		Long dniJugadorNegras			=Long.parseLong(request.getParameter("DniNegras"));
		String apellidoJugadorNegras 	=request.getParameter("ApellidoNegras");
		String nombreJugadorNegras 		=request.getParameter("NombreNegras");
		
		String[] datosJugadorBlancas = new String[2];
		String[] datosJugadorNegras  = new String[2];
		// busca jugadores en DB
		datosJugadorBlancas = ctrl.recDatosJugador(dniJugadorBlancas);
		datosJugadorNegras  = ctrl.recDatosJugador(dniJugadorNegras);
		// si no los encuentra, crea y settea datos
		
		if (datosJugadorBlancas[0].equals("")){
			ctrl.setJugador(dniJugadorBlancas, apellidoJugadorBlancas, nombreJugadorBlancas);	
		}else {
			apellidoJugadorBlancas 	= datosJugadorBlancas[1];
			nombreJugadorBlancas	= datosJugadorBlancas[0];
		}
		
		if (datosJugadorNegras[0].equals("")){
			ctrl.setJugador(dniJugadorNegras, apellidoJugadorNegras, nombreJugadorNegras);	
		}else {
			apellidoJugadorNegras 	= datosJugadorNegras[1];
			nombreJugadorNegras	= datosJugadorNegras[0];
		}
		
		
		request.setAttribute("DniBlancas", dniJugadorBlancas);
		request.setAttribute("ApellidoBlancas",apellidoJugadorBlancas);
		request.setAttribute("NombreBlancas", nombreJugadorBlancas);
		
		request.setAttribute("DniNegras", dniJugadorNegras);
		request.setAttribute("ApellidoNegras",apellidoJugadorNegras);
		request.setAttribute("NombreNegras", nombreJugadorNegras);
		request.getRequestDispatcher("redirected.jsp").forward(request, response);
	}

	
}
