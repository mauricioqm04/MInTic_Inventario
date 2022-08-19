package inventario;

public class Producto {
	// declaraciones de variables de instacia
	private String nombre;
	private int precio;
	private int cantExistencia;
	private int identificador;
	private boolean estado=true;
	
	

//contructor sin parametros para inicializar las variables en sus valores predeterminados 
	public Producto() {
	}// end constructor

	public Producto(String nombre, int precio, int cantExistencia, int identificador) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.cantExistencia = cantExistencia;
		this.identificador = identificador;
	}// end constructor
	
	public void addCantToInventory(int cantidad){		//Si no funcionacon void se puede intentar con int
		this.cantExistencia = cantExistencia+cantidad;	//Se esta intentando crear un metodo
		//return cantExistencia;		
	} //end addCantToInventory
	
	public int deductFromInventory(int cantidad) {
		this.cantExistencia -=cantidad;
		return cantExistencia;
	}//end deductFromInventory method	
	

//A continuacion se agregan los metodos getters/captadores and setters/establecedores
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantExistencia() {
		return cantExistencia;
	}

	public void setCantExistencia(int cantExistencia) {
		this.cantExistencia = cantExistencia;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public int InventoryValue() {
		return cantExistencia*precio;
	}
	
	
	//metodo toString() para imprimir los datos mas facilmente
	@Override
	public String toString() {
		estado=(cantExistencia>10)?true:false;
		return "Item number: "+ identificador
				+ "\tName: " + nombre
				+ "\tCantidad en stock: " + cantExistencia
				+ "\tPrecio: " + precio
				+ "\tValor total: " + InventoryValue()
				+"\tEstado: " + estado;
	}//end class toString

}// end class product