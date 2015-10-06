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
		int columInicial = (int) origen.substring(0,1).charAt(0);
		int columFinal   = (int) destino.substring(0,1).charAt(0);
		int filaInicial  = Integer.parseInt(origen.substring(1, 2));
		int filaFinal    = Integer.parseInt(destino.substring(1,2));
		
		if ( columInicial == columFinal || columInicial == columFinal - 1 || columInicial == columFinal + 1 ){
			if ( filaInicial == filaFinal || filaInicial == filaFinal - 1 || filaInicial == filaFinal + 1 ){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return "rey";
	}
}
	
	
	

	
