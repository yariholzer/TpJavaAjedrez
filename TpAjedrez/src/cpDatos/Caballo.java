package cpDatos;

public class Caballo extends Piezas{
	private String color, nombre = "C";
	
	
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
		
		if (columFinal == columInicial + 2 || columFinal == columInicial - 2 ){
			if (filaFinal == filaInicial + 1 || filaFinal == filaInicial - 1){
				return true;
			}else{
				return false;
			}
		}else{
			if (filaFinal == filaInicial + 2 || filaFinal == filaInicial - 2){
				if (columFinal == columInicial + 1 || columFinal == columInicial - 1){
					return true;
				}else {
					return false;
				}
			}else{
				return false;
			}
		}
	}

	@Override
	public String getTipoPieza() {
		return "caballo";
	}


}
