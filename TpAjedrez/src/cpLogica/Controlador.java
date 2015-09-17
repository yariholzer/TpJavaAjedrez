package cpLogica;

import cpDatos.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import cpDatos.Piezas;


public class Controlador {

	HashMap<String,Piezas> tablero =new HashMap<String,Piezas>();
	Jugador jugadorBlancas = new Jugador();
	Jugador jugadorNegras  = new Jugador();
	
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
			
			ficha =tablero.get(posicion).getNombre();
	
			
			return ficha;
		} catch (Exception e) {
			// TODO: handle exception
			return " ";
		}
		
	};

	public void nuevaPartida(long dniBlancas, String nombreBlancas, String apellBlancas, long dniNegras, String nombreNegras, String apellNegras) {

			jugadorBlancas.setDni(dniBlancas);
			jugadorBlancas.setApellido(apellBlancas);
			jugadorBlancas.setNombre(nombreBlancas);

			jugadorNegras.setDni(dniNegras);
			jugadorNegras.setApellido(apellNegras);
			jugadorNegras.setNombre(nombreNegras);
			
			
		}	
		
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
			posRey	 = "d8";
			posReina = "e8";
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
			case 'a': case 'h':
				posicion = i + fila1;
				Torre torre= new Torre();
				torre.setColor(color);
				torre.setNombre(nombreTorre);
				tablero.put(posicion,torre);
				nombreTorre++;
				break;
			case 'b': case 'g':
				posicion =  i + fila1;
				Alfil alfil= new Alfil();
				alfil.setColor(color);
				alfil.setNombre(nombreAlfil);
				tablero.put(posicion,alfil);
				nombreAlfil++;
				break;
			case 'c': case 'f':
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
			rey.setNombre(1);
			tablero.put(posRey,rey);
			
			Reina reina= new Reina();
			reina.setColor(color);
			reina.setNombre(1);
			tablero.put(posReina,reina);
			
		
			
		}
		
	}

	public void moverPiezas(String origen, String destino){
		if (tablero.containsKey(origen))
			{
				if (tablero.get(origen).validarMovimiento(origen, destino))
					{
						tablero.put(destino, tablero.get(origen));
						tablero.put(origen, null);
						JOptionPane.showMessageDialog(null, "la ficha fue movida");
						
					}
					else{
						JOptionPane.showMessageDialog(null, "la ficha elegida no se puede mover de esa manera");
						}
					}else 
					JOptionPane.showMessageDialog(null, "MOVIMIENTO NO VALIDO!! en la posicion de origen no hay ficha");
				
								
			}

	public String devolverColor(String posicion){
		String color;
		color=tablero.get(posicion).getColor();
		return color;
		
		
	};
	
	public String devolverTurno(int turno, String jug1, String jug2){
		if(turno%2==0){
			turno= turno +1;
			return jug1;}
			else {
				turno= turno +1;
				return jug2;}
		
		}
		
		
	}


