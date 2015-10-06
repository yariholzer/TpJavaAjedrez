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
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return "reina";
	}

}
