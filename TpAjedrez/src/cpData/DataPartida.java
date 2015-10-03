package cpData;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DataPartida {

	public DataPartida(){
	};
	
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
		
	};
	
}
	
