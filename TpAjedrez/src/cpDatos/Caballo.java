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
		// TODO Auto-generated method stub
		return true;
	}


}
