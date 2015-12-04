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

@WebServlet("/play")
public class Game extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
public Game(){}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		
		// recarga la partida
		
		cpLogica.CtrlAjedrez ctrl = (cpLogica.CtrlAjedrez) se.getAttribute("Controlador");
		HashMap<String,Piezas> tablero = (HashMap<String,Piezas>)se.getAttribute("tablero");
		
				
		String[] turnoActual = new String[2];
		
		//mover piezas
		
		String posOrigen = request.getParameter("posOrigen").toLowerCase();
		String posDestino = request.getParameter("posDestino").toLowerCase();
		String resultado = ctrl.moverPiezas(posOrigen, posDestino);
		
		if (resultado.equals("rey")) {
			turnoActual = ctrl.devolverTurnoActual();
			se.setAttribute("NombreTAct", turnoActual[1]);
			se.setAttribute("ApellidoTAct", turnoActual[0]);
			ganaPartida(request, response, se, turnoActual);
		}else{
			se.setAttribute("resultado", resultado);
			tablero = ctrl.recuperarTablero();
			se.setAttribute("tablero", tablero);
			
			//devuelve turno
			turnoActual = ctrl.devolverTurnoActual();
			se.setAttribute("NombreTAct", turnoActual[1]);
			se.setAttribute("ApellidoTAct", turnoActual[0]);
			
			request.getRequestDispatcher("game.jsp").forward(request, response);
		}		

		
	}

	private void ganaPartida(HttpServletRequest request, HttpServletResponse response, HttpSession se,
		String[] turnoActual) throws ServletException, IOException {
		se.setAttribute("ApellidoTAct", turnoActual[1]);
		se.setAttribute("NombreTAct", turnoActual[0]);
		request.getRequestDispatcher("ganador.jsp").forward(request, response);
	}

}
