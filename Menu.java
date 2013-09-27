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
		
			System.out.println("Seleccione una opción:" +
			"\n1) Agregar un Libro" + 
			"\n2) Eliminar un Libro" +
			"\n3) Buscar un Libro" +
			"\n4) Modificar un Libro" +
			"\n5) Listar Colección de Libros" +
			"\n6) Salir");
			
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
		System.out.println("Agregar Libros");
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