package inventario;
import java.util.Scanner; //se importa la clase scaner para capturar datos ingresados

public class ProductTester {

	public static void main(String[] args) {
		//create a scanner object for keyboard input
		Scanner in = new Scanner(System.in);
		int maxSize, menuChoice; //longitud del vector

		//Se le asigna a maxSize el valor que devuelva el metodo 
		maxSize=getNumbProducts(in);
				
		if(maxSize==0) {
			System.out.println("\nNO se requieren productos. ");
		}//end if		
		else if(maxSize!=0) {
			Producto[] vectorProductos = new Producto[maxSize];
			addToInventory(vectorProductos, in);
			do {
				menuChoice=getMenuOption(in);
				executeMenuChoice(menuChoice, vectorProductos, in);
			}while(menuChoice!=0);	
			displayInventory(vectorProductos);
		}//end else if
		//Se cierra el escaner
		in.close();			
	}//end main
	
	//execute menu method
	public static void executeMenuChoice(int menuChoice, Producto vectorProductos[], Scanner in) {
		switch(menuChoice) {
		//Ver inventario (solo por nombre y numero)
		case 1:
			System.out.println("View Product List");
			getProductNumber(vectorProductos, in);
			break;
		//agregar productos al inventario
		case 2: 
			System.out.println("Add stock");
			addInventory(vectorProductos, in);
			break;
		//deduct stock
		case 3:
			System.out.println("Deduct stock");
			deductInventory(vectorProductos, in);
			break;
		//Discontinue stock
		case 4:
			System.out.println("");
			discontinueInventory(vectorProductos, in);
			break;			
		}//end switch		
	}//end execute menu method
	
	//main menu method
	public static int getMenuOption(Scanner in) {
		int opcion=-1;
		do {
			try {
				System.out.println("\n------MENU-------\n");
				System.out.println("\n1. View inventory");
				System.out.println("\n2. Add stock");
				System.out.println("\n3. Deduct stock");
				System.out.println("\n4. Discontinue product");
				System.out.println("\n0. Exit.");
				System.out.println("\nOpcion: ");
				opcion=in.nextInt();
				
				if(opcion<0 || opcion>4) {
					System.out.println("Opción no válida");
				}//end if 0<opcion<4
			}//end try
			
			catch(Exception e) {
				System.out.println("El valor ingresado no corresponde a digito valido");
				in.next();
			}//end catch
			
		}while(opcion<0||opcion>4);
		//end do-while
		
		return opcion;
	}//end menu
	
	//view inventroy method
	private static int getProductNumber(Producto[] vectorProductos, Scanner in) {
		int productChoice = -1;
		do {			
			try {
				
				for(int i=0; i<vectorProductos.length; i++) {
					System.out.println(i + " " + vectorProductos[i].getNombre());
				}//end for
				
				System.out.println("Elija un producto segun su numero");
				productChoice=in.nextInt();//se elije el producto
				
				if(productChoice<0||productChoice>vectorProductos.length) {
					System.out.println("Numero incorrecto");
				}
				
			}//end try
			catch(Exception e) {
				System.out.println("Ingreso invalido");
				in.next();
			}//end catch
			
		}while(productChoice<0||productChoice>vectorProductos.length);	
		//end Do-While		
		return productChoice;
	}//end getProductNumber
	
	//add inventory to selected product
	private static void addInventory(Producto vectorProductos[], Scanner in) {
		int productChoice, updateValue=-1;
		productChoice=getProductNumber(vectorProductos, in);
		do {
			try {
				System.out.println("\n¿Cuantos productos quiere agregar?");
				updateValue=in.nextInt();
				if(updateValue<0) {
					System.out.println("NO puede ingresar numeros negativos.");
				}//end if
				else {
					//Se debe revisar esta parte del codigo el punto C iv. Si no funciona esta parte del codigo validar
					vectorProductos[productChoice].addCantToInventory(updateValue);					
					//vectorProductos[productChoice].setCantExistencia(pr.addCantToInventory(updateValue));
				}//end else
				
			}//end try
			catch(Exception e) {
				System.out.println("¡Valor invalido!");
				in.next();
			}//end catch
		}while(updateValue<0);
		//end do-while		
	}//end addInventory
		
	//reduct inventory to selected product
	private static void deductInventory(Producto vectorProductos[], Scanner in) {
		int productChoice, updateValue=-1;
		productChoice=getProductNumber(vectorProductos, in);
		do {
			try {
				System.out.println("\n¿Cuantos productos quiere quitar?");
				updateValue=in.nextInt();
				if(updateValue<0||updateValue>vectorProductos[productChoice].getCantExistencia()) {
					System.out.println("NO puede ingresar numeros negativos y no puede reducir mas "
							+"de la cantidad existente");
				}//end if
				else {
					//Se debe revisar esta parte del codigo el punto C iv. Si no funciona esta parte del codigo validar
					vectorProductos[productChoice].deductFromInventory(updateValue);
					//vectorProductos[productChoice].setCantExistencia(pr.addCantToInventory(updateValue));
				}//end else
				
			}//end try
			catch(Exception e) {
				System.out.println("¡Valor invalido!");
				in.next();
			}//end catch
		}while(updateValue<0);
		//end do-while		
	}//end addInventory
	
	//discontinue inventory method
	public static void discontinueInventory(Producto vectorProductos[], Scanner in) {
		int productChoice;
		productChoice=getProductNumber(vectorProductos, in);
		vectorProductos[productChoice].setEstado(false);
	}//end discontinue inventory method

	//Metodo para imprimir el vector de productos
	public static void displayInventory(Producto[] vectorProductos) {
		//for each
		for(Producto mostrarProductos: vectorProductos) {
			System.out.println(mostrarProductos);
		}//end for
		
	}//end displayInventory method
	
	//metodo para agregar productos al vector 
	public static void addToInventory(Producto[] vectorProductos, Scanner in) {
		for (int i=0; i<vectorProductos.length; i++) {
			int stockChoice=-1;
			
			try {
				System.out.println("1. CD" 
						+ "\n2. DVD"
						+ "\nPlease enter the produtc type. ");
				stockChoice = in.nextInt();
				
				if(stockChoice <1 || stockChoice >2) {
					System.out.println("Only numbers 1 or 2 allowed!");
					i--;
				}else if(stockChoice==1) {
					addCDToInventory(vectorProductos, in, i);
				}else {
					addDVDToInventory(vectorProductos, in, i);
				}
				
			}catch(Exception e) {
				System.out.println("Entrada invalida!!");
				i--;				
			}//end try-catch

			System.out.println("Ingreso correcto");
		}//end for
	}//end addToInventory
	
	//metodo para agregar CD productos al vector 
	public static void addCDToInventory(Producto[] vectorProductos, Scanner in, int i) {
		//for (int i=0; i<vectorProductos.length; i++) {
			int tempNumber=0, tempQty=0, tempPrice=0, tempNumCanciones=0;
			String tempName, tempArtista, tempDiscografia;
			//in.next();//Siempre que se introduzca un tipo de dato diferente al anterior se debe ingresar esto		
			//Se pide ingresar los datos
			System.out.println("Ingrese el Nombre del producto: ");
			tempName=in.next();
			System.out.println("Ingrese el Artista del CD: ");
			tempArtista=in.next();
			System.out.println("Ingrese la discografia: ");
			tempDiscografia=in.next();
			System.out.println("Ingrese el numero de canciones: ");
			tempNumCanciones=in.nextInt();
			System.out.println("Ingrese la cantidad en stock: ");
			tempQty=in.nextInt();
			System.out.println("Ingrese el precio del producto: ");
			tempPrice=in.nextInt();
			System.out.println("Ingrese el codigo del producto: ");
			tempNumber=in.nextInt();
			
			//Para cada posicion dle vector se crea un producto y se le asignan valores				
			vectorProductos[i]=new CD(tempName, tempArtista, tempDiscografia, tempNumCanciones, tempQty, tempPrice, tempNumber);			
			System.out.println("Ingreso correcto");
		//}//end for
	}//end addCDToInventory
	
	//metodo para agregar DVD productos al vector 
	public static void addDVDToInventory(Producto[] vectorProductos, Scanner in, int i) {
		//for (int i=0; i<vectorProductos.length; i++) {
			int tempNumber=0, tempQty=0, tempPrice=0, tempDuracion=0, tempEdad;
			String tempName, tempEstudio;
			//in.next();//Siempre que se introduzca un tipo de dato diferente al anterior se debe ingresar esto		
			//Se pide ingresar los datos
			System.out.println("Ingrese el Nombre del producto: ");
			tempName=in.next();
			System.out.println("Ingrese el estudio de grabacion: ");
			tempEstudio=in.next();
			System.out.println("Ingrese clasificacion de edad: ");
			tempEdad=in.nextInt();
			System.out.println("Ingrese duracion en minutos: ");
			tempDuracion=in.nextInt();
			System.out.println("Ingrese la cantidad en stock: ");
			tempQty=in.nextInt();
			System.out.println("Ingrese el precio del producto: ");
			tempPrice=in.nextInt();
			System.out.println("Ingrese el codigo del producto: ");
			tempNumber=in.nextInt();
			
			//Para cada posicion dle vector se crea un producto y se le asignan valores				
			vectorProductos[i]=new DVD(tempName, tempEstudio, tempEdad, tempDuracion, tempQty, tempPrice, tempNumber);			
			System.out.println("Ingreso correcto");
		//}//end for
	}//end addDVDToInventory
	
	//pedir la cantidad de productos a ingresar
	static int getNumbProducts(Scanner in){
		int maxSize=-1; //longitud del vector
		do {			
			try {
				System.out.println("Enter the number of products you would like to add\r\n"
						+ "Enter 0 (zero) if you do not wish to add products:");
				maxSize = in.nextInt();	//se captura el numero			
				if(maxSize<0) {
					System.out.println("Valor introducido incorrecto.\n");
				}//end if				
			}//end try
			
			catch(Exception e) {
				System.out.println("No es un numero\n\n"); 
				in.next(); //Se limpia el buffer de entrada, sin esto se ejecuta infinitamente
			}
			
		}while(maxSize<0); //end do-while
		
		return maxSize;
	}
	

}//end class productTester
