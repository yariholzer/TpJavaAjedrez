package cpLogica;

import cpDatos.*;

import java.util.HashMap;

import cpDatos.Piezas;

public class Controlador {

	HashMap<String,Piezas> tablero =new HashMap<String,Piezas>();
	
	public void inicializar(String color){
		
		//establecer posiciones segun color
		
		String fila1, fila2, posRey, posReina, posicion;
		
		if (color.equals("BLANCO")) {
			fila1 = "A";
			fila2 = "B";
			posRey	 = "A4";
			posReina = "A5";
			
		} else {
			fila1 = "H";
			fila2 = "G";
			posRey	 = "H5";
			posReina = "H4";
		}
		
		// setear peones
		
		for (int i = 1; i <= 8; i++) {
			
			posicion = fila2 + i;
			
			Peon peon= new Peon();
			peon.setColor(color);
			peon.setNombre(i);
			tablero.put(posicion,peon);
			
		} 
		
		//setear el resto
		
		for (int i = 1; i <= 8; i++) {
			switch (i) {
			case 1:
				posicion = fila1 + i;
				Torre torre= new Torre();
				torre.setColor(color);
				torre.setNombre(i);
				tablero.put(posicion,torre);
				break;
			case 2:
				posicion = fila1 + i;
				Alfil alfil= new Alfil();
				alfil.setColor(color);
				alfil.setNombre(i);
				tablero.put(posicion,alfil);
				break;
			case 3:
				posicion = fila1 + i;
				Caballo caballo= new Caballo();
				caballo.setColor(color);
				caballo.setNombre(i);
				tablero.put(posicion,caballo);
				break;
			}
			
			Rey rey= new Rey();
			rey.setColor(color);
			rey.setNombre(i);
			tablero.put(posRey,rey);
			
			Reina reina= new Reina();
			reina.setColor(color);
			reina.setNombre(i);
			tablero.put(posReina,reina);
			
		}
		
	}
	
}
