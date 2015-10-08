package cpDatos;

public class Torre extends Piezas{
	private String color, nombre = "T";
	
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
		
	/*	String filaInicial = origen.substring(0,1);
		String filaFinal = destino.substring(0,1);
		int columInicial = Integer.parseInt(origen.substring(1, 2));
		int columFinal = Integer.parseInt(destino.substring(1,2));
		
		if (filaFinal.equals(filaInicial) || columFinal==columInicial){
			return true;
		}else {
			return false;
		}*/
		return true;
	}

	@Override
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return "torre";
	}
	

}
