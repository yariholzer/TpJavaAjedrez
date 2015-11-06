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
		
		int columInicial =(int) origen.substring(0,1).charAt(0);
		int columFinal = (int) destino.substring(0,1).charAt(0);
		int filaInicial = Integer.parseInt(origen.substring(1, 2));
		int filaFinal = Integer.parseInt(destino.substring(1,2));
		
		if(columInicial==columFinal)
		{if(this.getColor().equals("BLANCO")){
			if (filaInicial==2){
				if(filaFinal<=filaInicial+2) return true;
				else return false;
			}else if(filaFinal==filaInicial+1) return true;
				  else return false;
		}else  if (filaInicial==7){
					if(filaFinal>=filaInicial-2) return true;
					else return false;
			  }else if(filaFinal==filaInicial-1) return true;
			  		else return false;
			
		}else {
			return false;
		}
	}
	
	public boolean comer(String origen, String destino){
		int columInicial = (int) origen.substring(0,1).charAt(0);
		int columFinal   = (int) destino.substring(0,1).charAt(0);
		int filaInicial  = Integer.parseInt(origen.substring(1, 2));
		int filaFinal    = Integer.parseInt(destino.substring(1,2));
		
		if (columFinal == columInicial + 1 || columFinal == columInicial - 1 ){
			if (this.getColor().equals("BLANCO")){
				if (filaFinal == filaInicial + 1){
					return true;
				}else{
					return false;
				}
			}else{
				if (filaFinal == filaInicial - 1){
					return true;
				}else{
					return false;
				}
			}
		}else{
			return false;
		}
	}
	
	@Override
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return "peon";
	}
	
	
	
}
