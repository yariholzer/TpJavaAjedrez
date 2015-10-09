package cpData;

import java.sql.*;
import java.util.ArrayList;

import cpDatos.Partida;
import cpDatos.Piezas;

public class DataPartida {
	
public int recuperarPartida (long dniBlancas, long dniNegras){
	
	ResultSet rs1   = null;
	Statement stmt1 = null;
	String 	  select;
	int idPartida = 0;
	
	try {
		stmt1  = Conexion.getInstancia().getConn().createStatement();
		select = "SELECT * FROM partidas WHERE dniBlancas = " + Long.toString(dniBlancas) + " AND dniNegras = " + Long.toString(dniNegras) + ";";
		rs1    = stmt1.executeQuery(select);
		if(rs1!=null && rs1.next()){
			idPartida = rs1.getInt("idPartida");
		}			
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return idPartida;
}

public ResultSet getPosiciones(int idPartida) {
		
		ResultSet rs1   = null;
		Statement stmt1 = null;
		String	  select;
		
		try {
			stmt1  = Conexion.getInstancia().getConn().createStatement();
			select = "SELECT * FROM posiciones WHERE idPartida = " + Integer.toString(idPartida) + ";";
			rs1    = stmt1.executeQuery(select);	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return rs1;
		
	}

public String[] recDatosJugador(long dni) {

	ResultSet rs1   = null;
	Statement stmt1 = null;
	String select;
	String[] datosJugador = new String[2];
	
	try {
		stmt1  = Conexion.getInstancia().getConn().createStatement();
		select = "SELECT * FROM jugadores WHERE dni = " + Long.toString(dni) + ";";
		rs1    = stmt1.executeQuery(select);
		if(rs1!=null && rs1.next()){
			datosJugador[0] = rs1.getString("nombre");
			datosJugador[1] = rs1.getString("apellido");
		}else{
			datosJugador[0] = "";
			datosJugador[1] = "";
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return datosJugador;
};

public void setJugador(long dniJugador, String apellJugador, String nombreJugador){
	Statement stmt1 = null;
	String	  insert= null;
	
	try{
		stmt1  = Conexion.getInstancia().getConn().createStatement();
		insert = "INSERT INTO `ajedrez`.`jugadores` (`dni`, `nombre`, `apellido`) VALUES ('" + Long.toString(dniJugador) +"', '"+ nombreJugador +"', '"+ apellJugador +"');";
		stmt1.execute(insert);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

public void guardarPartida (Partida pa){
	long dniBlancas = pa.getJugadorBlancas().getDni();
	long dniNegras  = pa.getJugadorNegras().getDni();
	int turno		= pa.getTurnoActual();
	int idPartidaNueva;
	
	idPartidaNueva = setPartida(dniBlancas, dniNegras, turno);
	
	for (String posicion : pa.tablero.keySet()) {
		Piezas piezaActual = pa.tablero.get(posicion);
		String tipoPieza = piezaActual.getTipoPieza();
		String nombrePieza = piezaActual.getNombre();
		String colorPieza = piezaActual.getColor();
		setPosicion(idPartidaNueva, tipoPieza, nombrePieza, colorPieza, posicion);
	}
	
	
}

private int setPartida(long dniBlancas, long dniNegras, int turno){
	ResultSet rs1   		= null;
	Statement stmt1, stmt2  = null;
	String select, insert	= null;
	int idPartidaNueva = 0;
	
	try {
		stmt1  = Conexion.getInstancia().getConn().createStatement();
		select = "SELECT max(idPartida) FROM partidas;";
		rs1    = stmt1.executeQuery(select);
		if(rs1!=null && rs1.next()){
			idPartidaNueva = rs1.getInt(1) +1;
		}else{
			idPartidaNueva = 1;
		}
		stmt2  = Conexion.getInstancia().getConn().createStatement();
		insert = "INSERT INTO `ajedrez`.`partidas` (`idPartida`, `dniBlancas`, `dniNegras`, `turno`) VALUES ('"+ Integer.toString(idPartidaNueva) + "', '"+ Long.toString(dniBlancas) +"', '" + Long.toString(dniNegras) + "', '"+ Integer.toString(turno) +"');";
		stmt2.execute(insert);		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return idPartidaNueva;
}

private void setPosicion(int idPartida, String tipoPieza, String nombrePieza, String color, String posicion){
	Statement stmt1 = null;
	String	  insert= null;
	
	try{
		stmt1  = Conexion.getInstancia().getConn().createStatement();
		insert = "INSERT INTO `ajedrez`.`posiciones` (`idPartida`, `tipoPieza`, `nombrePieza` , `colorPieza` , `posicion`) VALUES ('" + Integer.toString(idPartida) +"', '"+ tipoPieza +"', '"+ nombrePieza +"', '"+ color +"', '"+ posicion +"');";
		stmt1.execute(insert);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
	
