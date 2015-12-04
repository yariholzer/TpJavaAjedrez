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

@WebServlet("/login")
public class Login  extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;

	public Login(){}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cpLogica.CtrlAjedrez ctrl = new CtrlAjedrez();
		HttpSession se = request.getSession();
		
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
		
		
		se.setAttribute("DniBlancas", dniJugadorBlancas);
		se.setAttribute("ApellidoBlancas",apellidoJugadorBlancas);
		se.setAttribute("NombreBlancas", nombreJugadorBlancas);
		
		se.setAttribute("DniNegras", dniJugadorNegras);
		se.setAttribute("ApellidoNegras",apellidoJugadorNegras);
		se.setAttribute("NombreNegras", nombreJugadorNegras);
	
	
		// busca partida en DB
		
		HashMap<String,Piezas> tablero =new HashMap<String,Piezas>();
		tablero = ctrl.nuevaPartida(dniJugadorBlancas, nombreJugadorBlancas, apellidoJugadorBlancas, dniJugadorNegras, nombreJugadorNegras, apellidoJugadorNegras);
		se.setAttribute("tablero", tablero);
		
		// devuelve turno
		String[] turnoActual= new String[2];
		turnoActual = ctrl.devolverTurnoActual();
		se.setAttribute("NombreTAct", turnoActual[1]);
		se.setAttribute("ApellidoTAct", turnoActual[0]);
		se.setAttribute("Controlador", ctrl);
		
		//devuelve mensaje vacio
		se.setAttribute("resultado", "Bienvenidos a la partida");
		
		
		
		request.getRequestDispatcher("game.jsp").forward(request, response);
	}

	
}
