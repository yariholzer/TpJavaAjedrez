package cpLogica;

import java.util.*;

import cpDatos.*;
import cpData.*;

import javax.swing.JOptionPane;

public class CtrlAjedrez {
	
	// NUEVO CONTROLADOR
	
	Partida p      = new Partida();
	DataPartida dp = new DataPartida();
	
	public  HashMap<String, Piezas> nuevaPartida(long dniBlancas, String nombreBlancas, String apellBlancas, long dniNegras, String nombreNegras, String apellNegras){
		
		int idPartida=0;
		
		idPartida = dp.recuperarPartida(dniBlancas, dniNegras);
		
		if (idPartida==0){
			p.inicializar("BLANCO");
			p.inicializar("NEGRO");
			}
		else
			{
			p.setPosiciones(dp.getPosiciones(idPartida));
			};
		return p.getTablero();
			
}

	public boolean moverPiezas(String origen, String destino){
		return p.moverPiezas(origen, destino);
	}
	
	public Jugador devolverTurno(){
		return p.devolverTurno();
	}

	public String recuperarFicha(String posicion){
		return p.recuperarFicha(posicion);
	};

	public String[] recDatosJugador(long dni) {
		
		return dp.recDatosJugador(dni);
			
	}
	
	public void setJugador(long dniJugador, String apellJugador, String nombreJugador){
		dp.setJugador(dniJugador, apellJugador, nombreJugador);
	}

	public void guardarPartida() {
		dp.guardarPartida(p);
	}
	
	
}
