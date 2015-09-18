package cpDatos;

import java.util.HashMap;

public class Partida {

	HashMap<String,Piezas> tablero =new HashMap<String,Piezas>();
	
	public int hashCode(String s){
		return (getFila(s)*getColumna(s));
	
	}	
	
	public int getFila(String ubicacion ){
		int fila = Integer.parseInt(ubicacion.substring(1,2));
		return fila;
		
	}

	public int getColumna(String ubicacion ){
		int columna = Integer.parseInt(ubicacion.substring(0,1));
				
		return columna;
		
	}
	
	public String retornarTablero(String posicion){
		
		try {
			String ficha;
			
			ficha = tablero.get(posicion).getNombre();
			
			return ficha;
		} catch (Exception e) {
			// TODO: handle exception
			return " ";
		}
		
	};
	
}
