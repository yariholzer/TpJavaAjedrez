package cpDatos;

public class Jugador {
	private long dni;
	String nombre;
	String apellido;
	String colorFichas;
	
	public String getColorFichas() {
		return colorFichas;
	}

	public void setColorFichas(String colorFichas) {
		this.colorFichas = colorFichas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}
	

}
