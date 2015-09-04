package cpDatos;

public class Rey extends Piezas {
	private String color, nombre ="R";
	
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(int nombreFicha) {
		this.nombre = nombre + nombreFicha;
	}

	@Override
	public boolean validarMovimiento(String origen, String destino) {
		String filaInicial = origen.substring(0,1);
		String filaFinal = destino.substring(0,1);
		int columInicial = Integer.parseInt(origen.substring(1, 2));
		int columFinal = Integer.parseInt(destino.substring(1,2));
		if ((columInicial-1) <=columFinal && columFinal <= (columInicial+1))
			{
			if ((Integer.parseInt(filaInicial)-1) <=Integer.parseInt(filaFinal) && Integer.parseInt(filaFinal) <= (Integer.parseInt(filaInicial)+1))
					return true;
			else return false;
			}
		
		else 
		return false;
		
				
	}
}
	
	
	

	
