package cpData;

import java.sql.*;

import java.util.ArrayList;

public class DataPartida {

//	public DataPartida(){
//	};
	
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
		// TODO Auto-generated catch block
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
		insert	="INSERT INTO jugadores " + "VALUES ("+dniJugador+", "+nombreJugador+","+apellJugador+")";
		stmt1.execute(insert);
		
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

public void setPartida(long dniBlancas, long dniNegras, int turno){
	ResultSet rs1   		= null;
	Statement stmt1, stmt2  = null;
	String select, insert	= null;
	int idPartidaNueva;
	
	try {
		stmt1  = Conexion.getInstancia().getConn().createStatement();
		select = "SELECT MAX (idPartidas) FROM partidas";
		rs1    = stmt1.executeQuery(select);
		if(rs1!=null && rs1.next()){
			idPartidaNueva = rs1.getInt("idPartida") + 1;
		}else{
			idPartidaNueva = 1;
		}
		stmt2  = Conexion.getInstancia().getConn().createStatement();
		insert	="INSERT INTO partidas " + "VALUES ("+ idPartidaNueva +", "+ dniBlancas +","+ dniNegras + "," + turno + ")";
		stmt2.execute(insert);
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
}

}
	
