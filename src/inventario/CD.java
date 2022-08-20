package inventario;

public class CD extends Producto{
	private String artista;
	private int numCanciones;
	private String discografia;
	
	//constructor CD 
	public CD(String nombre, String artista, String discografia, int numCanciones,
		int cantExistencia, int precio, int identificador) {
		super(nombre, precio, cantExistencia, identificador);
		this.artista=artista;
		this.numCanciones=numCanciones;
		this.discografia=discografia;

	}//end constructor

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getNumCanciones() {
		return numCanciones;
	}

	public void setNumCanciones(int numCanciones) {
		this.numCanciones = numCanciones;
	}

	public String getDiscografia() {
		return discografia;
	}

	public void setDiscografia(String discografia) {
		this.discografia = discografia;
	}
	
	@Override
	public String toString() {
		return "Nombre del producto=" + getNombre() 
				+ "\tPrecio =" + getPrecio()
				+ "\tCantidad de existencias =" + getCantExistencia() 
				+ "\tNumero de elemento=" + getIdentificador()
				+ "\tArtista=" + artista
				+ "\tCantidad de canciones=" + numCanciones
				+ "\tDiscografia=" + discografia ;
	}//end toString	
	

}//end class
