package cpDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.DebugGraphics;
import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Partida {
	
	public int turnoActual = 0;

	public HashMap<String,Piezas> tablero =new HashMap<String,Piezas>();
	public Jugador jugadorBlancas = new Jugador();
	public Jugador jugadorNegras  = new Jugador();
	
	public int hashCode(String s){
		return (getFila(s)*getColumna(s));
	
	}	
	
	public int getTurnoActual() {
		return turnoActual;
	}

	public HashMap<String, Piezas> getTablero() {
		return tablero;
	}

	public Jugador getJugadorBlancas() {
		return jugadorBlancas;
	}

	public Jugador getJugadorNegras() {
		return jugadorNegras;
	}

	public int getFila(String ubicacion ){
		int fila = Integer.parseInt(ubicacion.substring(1,2));
		return fila;
		
	}

	public int getColumna(String ubicacion ){
		int columna = Integer.parseInt(ubicacion.substring(0,1));
				
		return columna;
		
	}
	
	public String recuperarFicha(String posicion){
		
		try {
			String ficha;
			
			ficha = tablero.get(posicion).getNombre();
			
			return ficha;
		} catch (Exception e) {
			// TODO: handle exception
			return " ";
		}
		
	};
	
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
	
	public String moverPiezas(String origen, String destino){//1
		String resultado=validacionInicial(origen, destino);
		if (resultado.equals("valido")){
		if(jugadorCorrecto(origen, devolverTurno()))
		{	
		String colorDestino = null, tipoDestino = "";
		if (tablero.containsKey(origen)){
			if(tablero.containsKey(destino)){
				colorDestino = tablero.get(destino).getColor();
				tipoDestino  = tablero.get(destino).getTipoPieza();
				}
			if (tablero.get(origen).getColor().equals(colorDestino))
			{//6
				return "En la posiocion de destino hay una ficha del mismo color";
			}//6
			else{//3
				if (tablero.get(origen).getTipoPieza().equals("peon") && colorDestino != null ){					
					if (((Peon) tablero.get(origen)).comer(origen, destino))
					{//5
						tablero.put(destino, tablero.get(origen));
						tablero.remove(origen);
						turnoActual++;
						return "Ficha movida";
					}//5
				else{//4
					return "la ficha elegida no se puede mover de esa manera";
					}//4
					
				}else{
					if (tablero.get(origen).validarMovimiento(origen, destino))
						{//5
							if (tipoDestino.equals("rey")){
								return "rey";
							}else{
								tablero.put(destino, tablero.get(origen));
								tablero.remove(origen);
								
								turnoActual++;
								return "Ficha movida";
							}
						}//5
					else{//4
						return "la ficha elegida no se puede mover de esa manera";
						}//4
					}//3
				}
			}//7	
		else{//2 
			return "MOVIMIENTO NO VALIDO!! en la posicion de origen no hay ficha";
			}//2;
		}else
			return "La ficha no corresponde al jugador actual ";
		}else return resultado;
}//1

	public void cargarJugadores(long dniBlancas, String nombreBlancas, String apellBlancas, long dniNegras, String nombreNegras, String apellNegras) {			
 		
		jugadorBlancas.setDni(dniBlancas);
		jugadorBlancas.setApellido(apellBlancas);
		jugadorBlancas.setNombre(nombreBlancas);
		jugadorBlancas.setColorFichas("BLANCO");

		jugadorNegras.setDni(dniNegras);
		jugadorNegras.setApellido(apellNegras);
		jugadorNegras.setNombre(nombreNegras);
		jugadorNegras.setColorFichas("NEGRO");
			
			
		}	

	public Jugador devolverTurno(){
		if(turnoActual%2==0){
			
			return jugadorBlancas;}
		else{
				
			return jugadorNegras;}
		
		}
	
	public String[] devolverTurnoActual(){
		String[] datosJugador = new String[2];
		if(turnoActual%2==0){
			datosJugador[0]=jugadorBlancas.getApellido();
			datosJugador[1]=jugadorBlancas.getNombre();
					
			return datosJugador;}
		else{
			
			datosJugador[0]=jugadorNegras.getApellido();
			datosJugador[1]=jugadorNegras.getNombre();
			return datosJugador;}
		
		
		}
	

	public String devolverColor(String posicion){
		String color;
		color=tablero.get(posicion).getColor();
		return color;
	};

	public boolean jugadorCorrecto(String posicion, Jugador jugadorAct ){
		if(tablero.get(posicion).getColor().equals(jugadorAct.colorFichas))
			return true;
		else 
			return false;
	}

	public void setPosiciones(ResultSet rsPosiciones) {
		
		String	tipoPieza, colorPieza, posicion;
		int nombrePieza;
		
		try {
			while (rsPosiciones!=null && rsPosiciones.next()) {
				tipoPieza   = rsPosiciones.getString("tipoPieza");
				nombrePieza = Integer.parseInt(rsPosiciones.getString("nombrePieza").substring(1,2));
				colorPieza  = rsPosiciones.getString("colorPieza");
				posicion 	= rsPosiciones.getString("posicion");
				
				switch (tipoPieza) {
				case "peon":
					Peon peon= new Peon();
					peon.setColor(colorPieza);
					peon.setNombre(nombrePieza);
					tablero.put(posicion,peon);
					break;

				case "torre":
					Torre torre= new Torre();
					torre.setColor(colorPieza);
					torre.setNombre(nombrePieza);
					tablero.put(posicion,torre);
					nombrePieza++;
					break;
					
				case "caballo":
					Caballo caballo= new Caballo();
					caballo.setColor(colorPieza);
					caballo.setNombre(nombrePieza);
					tablero.put(posicion,caballo);
					break;
					
				case "alfil":
					Alfil alfil= new Alfil();
					alfil.setColor(colorPieza);
					alfil.setNombre(nombrePieza);
					tablero.put(posicion,alfil);
					break;
					
				case "rey":
					Rey rey= new Rey();
					rey.setColor(colorPieza);
					rey.setNombre(nombrePieza);
					tablero.put(posicion,rey);
					break;
				
				case "reina":
					Reina reina= new Reina();
					reina.setColor(colorPieza);
					reina.setNombre(nombrePieza);
					tablero.put(posicion,reina);
					break;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String validacionInicial(String origen, String destino){
		String columnas, resultado= null;
		int filas;
		boolean bandera=false;
		columnas = origen.substring(0,1);
		filas =Integer.parseInt(origen.substring(1,2));
	
		if(columnas.matches("[a-h]"))
			{
				if (1<= filas && filas <= 8){
					bandera = true;}
				else resultado="la fila de origen ingresada es incorrecta ";
	
			}else 
				resultado="la columna de origen ingresada es incorrecta ";
	
		if (bandera==true)
			{
			columnas = destino.substring(0,1);
			filas =Integer.parseInt(destino.substring(1,2));
		
		if(columnas.matches("[a-h]"))
			{
			if (1<= filas && filas <= 8){
				resultado="valido";
				}
				else resultado="la fila de destino ingresada es incorrecta ";
		
			}else 
				resultado="la columna de destino ingresada es incorrecta ";}
		return resultado;
	}
}