import java.io.*;
import java.util.*;

public class Menu {
	
	private static Inventario inventario;
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
	}
	
	static {
		
		inventario = new Inventario();
		muestraMenu();
		
	}
	
	public static void muestraMenu() {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		cicloMenu:
		for(;;) {
		
			System.out.println("\nSeleccione una opción:" +
			"\n\t1) Agregar un Libro" + 
			"\n\t2) Eliminar un Libro" +
			"\n\t3) Buscar un Libro" +
			"\n\t4) Modificar un Libro" +
			"\n\t5) Listar Colección de Libros" +
			"\n\t6) Salir");
			
			int opcion = 0;
			
			try {
				opcion = Integer.parseInt(Console.readLine());
			} catch(NumberFormatException nfe) {
				//ignore...
			}
			
			switch(opcion) {
				
				case 1:
					agregarLibro();
					break;
				
				case 2:
					eliminarLibro();
					break;
				
				case 3:
					buscarLibro();
					break;
				
				case 4:
					modificarLibro();
					break;
				
				case 5:
					listarLibros();
					break;
					
				case 6:
					break cicloMenu; 
			}

		}
			
	}
	
	public static void agregarLibro() {
		
		String autor, titulo, isbn, sinopsis;
		Editorial editorial;
		Formato formato;
		int numDePag = 0, edicion = 0;
		int indice = 0;
		
		Console.println("\n-------Agregar Libro Nuevo-------\n");
		
		//Autor-----
		do {
			Console.print("\nNombre del autor: ");
			autor = Console.readLine();
		} while(autor.equals(""));
		
		//Titulo-----
		do {
			Console.print("\nTitulo del libro: ");
			titulo = Console.readLine();
		} while(titulo.equals(""));
		
		//Editorial-----
		cicloEditorial:
		while(true) {
			indice = 0;
			Console.println("\nIntroduza el numero de la editorial correspondiente");
			
			for(Editorial e: Editorial.values()){
			System.out.println("\t" + indice + ".-" + e);
			indice++;
			}
			
			String ed = Console.readLine();
			
			try {
				indice = Integer.parseInt(ed);
			} catch(NumberFormatException nfe) {
				//Ignore this thang, mate
			}
			
			if(indice>=0 && indice < Editorial.values().length) {
				break cicloEditorial;
			}
			
		}
		editorial = Editorial.values()[indice];
		
		//Formato
		cicloFormato:
		while(true) {
			indice = 0;
			Console.println("\nIntroduza el numero del formato correspondiente");
			
			for(Formato e: Formato.values()){
			System.out.println("\t" + indice + ".-" + e);
			indice++;
			}
			
			String fo = Console.readLine();
			
			try {
				indice = Integer.parseInt(fo);
			} catch(NumberFormatException nfe) {
				//Ignore this thang, mate.
			}
			
			if(indice>=0 && indice < Formato.values().length) {
				break cicloFormato;
			}
			
		}
		formato = Formato.values()[indice];
		
		//ISBN
		cicloIsbn:
		while(true) {
			System.out.print("\nISBN: ");
			
			isbn = Console.readLine();
			
			//Si no está vacío y contiene los 10 o 13 dígitos correspondientes
			if(!isbn.equals("") ) {
				
				if(isbn.replace("-","").length() == 10 || 
				   isbn.replace("-","").length() == 13 ) {
				   	break cicloIsbn;
				}
				
			} else {
				break cicloIsbn;
			}
		}
		
		//Número de páginas
		cicloNumPag:
		while(true)	{
			
			System.out.print("\nNumero de paginas: ");
			numDePag = -1;
			
			String numS = Console.readLine();
			
			if(!numS.equals("")) {
				
				try {
					numDePag = Integer.parseInt(numS);
				} catch(NumberFormatException nfe) {
					numDePag = -1;
				}
				
			} else {
				numDePag = 0;
			}
			
	
			if(numDePag >= 0) {
				break cicloNumPag;
			}
		}
		
		//Edición
		cicloEdicion:
		while(true)	{
			
			System.out.print("\nEdicion: ");
			edicion = -1;
			
			String edicionS = Console.readLine();
			
			if(!edicionS.equals("")) {
				
				try {
					edicion = Integer.parseInt(edicionS);
				} catch(NumberFormatException nfe) {
					edicion = -1;
				}
				
			} else {
				edicion = 0;
			}
			
	
			if(edicion >= 0) {
				break cicloEdicion;
			}
		}
		
		//Sinopsis
		System.out.println("Sinopsis: " );
		sinopsis = Console.readLine();
		
		//Verificación de datos
		System.out.print("\n\n----------Verifique-los-datos----------\n" +
						   "\nAutor: " + autor +
						   "\nTitulo: " + titulo +
						   "\nEditorial: " + editorial +
						   "\nFormato: " + formato +
						   "\nISBN: " + isbn +
						   "\nNumero de Paginas: " + numDePag +
						   "\nEdicion: " + edicion +
						   "\nSinopsis: ");
		//Imprime resumen de la sinopsis
		System.out.print( (sinopsis.length() < 50)? 
								sinopsis.substring(0, sinopsis.length()) :
								sinopsis.substring(0, 50) );
		System.out.print("...");
		
		//Agregar?
		while(true) {
			System.out.println("\n\nAgregar libro? S/N");
			
			String resp = Console.readLine();
			
			if(resp.equalsIgnoreCase("s")) {
				
				inventario.addLibro(isbn, numDePag, sinopsis,
					new DescripcionLibro(titulo, autor, editorial, formato,
										 edicion));
				System.out.println("\nEl libro ha sido agregado.");
				return;
				
			} else if(resp.equalsIgnoreCase("n")) {
				
				System.out.println("\nEl libro no ha sido agregado.");
				return;
				
			} 
			
			Console.readLine();
		}				   		

		
	}
	
	public static void eliminarLibro() {
		System.out.println("Eliminar Libros");
	}
	
	public static void buscarLibro() {
		System.out.println("Buscar Libros");
	}
	
	public static void modificarLibro() {
		System.out.println("Modificar Libros");
	}
	
	public static void listarLibros() {
		System.out.println("\nLibros Dentro del Inventario----------");
		
		List libros = inventario.getLibros();
		
		for(Iterator i = libros.iterator(); i.hasNext();) {
			Libro libro = (Libro) i.next();
			
			System.out.println("");
			System.out.println(libro);
			
		}
		
		System.out.println("--------------------");
		
	}
	
}