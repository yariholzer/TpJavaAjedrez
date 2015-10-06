package cpDatos;

public class Reina extends Piezas{
	
	private String color, nombre = "D";
	
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
	
		if ( Math.abs(columFinal - columInicial) == Math.abs( filaFinal - filaInicial ) && columFinal != columInicial && filaInicial != filaFinal){
			return true;
		} else {
			if (filaFinal == filaInicial || columFinal == columInicial){
				return true;
			}else {
				return false;
			}
		}
	}
	@Override
	public String getTipoPieza() {
		return "reina";
	}

}
