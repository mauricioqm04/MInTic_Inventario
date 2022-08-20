package inventario;

public class DVD extends Producto{
	private int duracion;
	private int clasificacionEdad;
	private String estudioCinematografico;
	
	
	//constructor
	public DVD(String nombre, String estudioCinematografico,  int 
			clasificacionEdad, int duracion, int cantExistencia, int precio, int identificador) {
		super(nombre, precio, cantExistencia, identificador);
		this.duracion=duracion;
		this.clasificacionEdad=clasificacionEdad;
		this.estudioCinematografico=estudioCinematografico;	
	}//end constructor


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public int getClasificacionEdad() {
		return clasificacionEdad;
	}


	public void setClasificacionEdad(int clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}


	public String getEstudioCinematografico() {
		return estudioCinematografico;
	}


	public void setEstudioCinematografico(String estudioCinematografico) {
		this.estudioCinematografico = estudioCinematografico;
	}
	
	public int InventoryValue() {
		return (getCantExistencia()*getPrecio())+InventoryValue()*5/100;	
	}


	@Override
	public String toString() {
		return "Nombre del producto=" + getNombre() 
				+ "\tPrecio =" + getPrecio()
				+ "\tCantidad de existencias =" + getCantExistencia() 
				+ "\tNumero de elemento=" + getIdentificador()
				+ "\tDuracion=" + duracion
				+ "\tclasificacion edad=" + clasificacionEdad 
				+ "\tEstudio cinematografico=" + estudioCinematografico ;
	}//end toString	
	
}//end class DVD 
