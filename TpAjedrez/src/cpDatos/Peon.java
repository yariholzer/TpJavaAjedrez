package cpDatos;

public class Peon extends Piezas{

	private String color, nombre = "P";
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(int nombreFicha) {
		this.nombre = nombre + nombreFicha;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public boolean validarMovimiento(String origen, String destino) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
