package cpDatos;

public class Reina extends Piezas{
	
	private String color;
	private int nombre;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	@Override
	public boolean validarMovimiento(String origen, String destino) {
		// TODO Auto-generated method stub
		return false;
	}

}
