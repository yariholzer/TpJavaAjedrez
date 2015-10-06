package cpLogica;

import cpDatos.*;
import cpData.*;

import java.sql.*;

import javax.swing.JOptionPane;

import cpPresentacion.pntAjedrez;

public class CtrlAjedrez {
	
	// NUEVO CONTROLADOR
	
	Partida p      = new Partida();
	DataPartida dp = new DataPartida();
	
	public void nuevaPartida(long dniBlancas, String nombreBlancas, String apellBlancas, long dniNegras, String nombreNegras, String apellNegras){
		
		int idPartida=0;
		
		idPartida = dp.recuperarPartida(dniBlancas, dniNegras);
		
		if (idPartida==0){
			p.inicializar("BLANCO");
			p.inicializar("NEGRO");
			p.cargarJugadores(dniBlancas, nombreBlancas, apellBlancas, dniNegras, nombreNegras, apellNegras);
		}else{
			int opcion = JOptionPane.YES_NO_CANCEL_OPTION;
			JOptionPane.showConfirmDialog(null,"Existe una partida guardada para estos jugadores. ¿Desea continuarla?","Atención!",opcion);
			if (opcion == JOptionPane.YES_OPTION){
				p.setPosiciones(dp.getPosiciones(idPartida));
				p.cargarJugadores(dniBlancas, nombreBlancas, apellBlancas, dniNegras, nombreNegras, apellNegras);
			}else{
				p.inicializar("BLANCO");
				p.inicializar("NEGRO");
				p.cargarJugadores(dniBlancas, nombreBlancas, apellBlancas, dniNegras, nombreNegras, apellNegras);
			};
			
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
