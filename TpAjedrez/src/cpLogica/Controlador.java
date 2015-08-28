package cpLogica;

import cpDatos.*;

import java.util.HashMap;

import cpDatos.Piezas;

public class Controlador {

	HashMap<String,Piezas> tablero =new HashMap<String,Piezas>();
	
	public void inicializar(String color){
		
		//establecer posiciones segun color
		int nombrePeon=1,nombreTorre=1, nombreAlfil=1, nombreCaballo=1;
		String fila1, fila2, posRey, posReina, posicion;
		
		if (color.equals("BLANCO")) {
			fila1 	 = "1";
			fila2 	 = "2";
			posRey	 = "e1";
			posReina = "d1";
			
		} else {
			fila1 	 = "8";
			fila2 	 = "7";
			posRey	 = "e8";
			posReina = "d8";
		}
		
		// setear peones
		
		
		for (char i = 'a'; i <= 'h'; i++) {
			
			posicion = i + fila2;
			Peon peon= new Peon();
			peon.setColor(color);
			peon.setNombre(nombrePeon);
			tablero.put(posicion,peon);
			nombrePeon++;
		} 
		
		//setear el resto
		
		for (char i = 'a'; i <= 'h'; i++) {
			switch (i) {
			case 'a':
				posicion = i + fila1;
				Torre torre= new Torre();
				torre.setColor(color);
				torre.setNombre(nombreTorre);
				tablero.put(posicion,torre);
				nombreTorre++;
				break;
			case 'b':
				posicion =  i + fila1;
				Alfil alfil= new Alfil();
				alfil.setColor(color);
				alfil.setNombre(nombreAlfil);
				tablero.put(posicion,alfil);
				nombreAlfil++;
				break;
			case 'c':
				posicion = i + fila1;
				Caballo caballo= new Caballo();
				caballo.setColor(color);
				caballo.setNombre(nombreCaballo);
				tablero.put(posicion,caballo);
				nombreCaballo++;
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
		
		System.out.print(tablero.toString());
	}
	
	
	
	public String filasColumnas(String ubicacion ){
		String fila =  ubicacion.substring(0,1);
		int columna = Integer.parseInt(ubicacion.substring(1,2));
		System.out.print("* ");
		System.out.print(fila);
		System.out.print("* ");
		System.out.print(columna);
		
		
		return null;
		
	}
	
}
