package cpLogica;

import cpDatos.*;
import cpData.*;

import java.sql.*;

import cpPresentacion.pntAjedrez;

public class CtrlAjedrez {
	
	// NUEVO CONTROLADOR
	
	Partida p      = new Partida();
	DataPartida dp = new DataPartida();
	
	public void nuevaPartida(long dniBlancas, String nombreBlancas, String apellBlancas, long dniNegras, String nombreNegras, String apellNegras){
		
		int idPartida;
		
		idPartida = dp.recuperarPartida(dniBlancas, dniNegras);
		
		if (idPartida==0){
			p.inicializar("BLANCO");
			p.inicializar("NEGRO");
			p.cargarJugadores(dniBlancas, nombreBlancas, apellBlancas, dniNegras, nombreNegras, apellNegras);
		}else{
			//
		}
		
	}

	public void moverPiezas(String origen, String destino){
		p.moverPiezas(origen, destino);
	}
	
	public Jugador devolverTurno(){
		return p.devolverTurno();
	}

	public String recuperarFicha(String posicion){
		return p.recuperarFicha(posicion);
	};

}
