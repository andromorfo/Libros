import java.io.*;
import java.util.*;

public class Menu {
	
	private static Inventario inventario;
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
	}
	
	static {
		inventario = new Inventario();
		menu();	
	}
	
	public static void menu() {
		
		cicloMenu:
		for(;;) {
		
			System.out.println("\n>>>>>>>>>>Seleccione-una-opcion<<<<<<<<<<" +
			"\n\t1) Agregar un Libro" + 
			"\n\t2) Eliminar un Libro" +
			"\n\t3) Buscar un Libro" +
			"\n\t4) Modificar un Libro" +
			"\n\t5) Listar Coleccion de Libros" +
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
					Console.readLine();
					break;
					
				case 6:
					break cicloMenu; 
			}

		}
			
	}
	
	//Funciones-del-Menú--------------------------------------------------------
	
	public static void agregarLibro() {
		
		Libro libroNuevo = new Libro();
		DescripcionLibro descripcionNueva = libroNuevo.getDescripcion();
		
		Console.println("\n>>>>>>>>>>Agregar-Libro-Nuevo<<<<<<<<<<\n");
		
		//Autor-----
		descripcionNueva.setAutor(selectAutor());
		//Titulo-----
		descripcionNueva.setTitulo(selectTitulo());
		//Editorial-----
		descripcionNueva.setEditorial(selectEditorial());
		//Formato
		descripcionNueva.setFormato(selectFormato());
		//ISBN
		libroNuevo.setIsbn(selectIsbn());
		//Páginas
		libroNuevo.setPaginas(selectPaginas());
		//Edición
		descripcionNueva.setEdicion(selectEdicion());
		//Sinopsis
		libroNuevo.setSinopsis(selectSinopsis());
		
		//Verificación de datos
		System.out.println(">>>>>>>>>>Verifique-los-Datos<<<<<<<<<<");
		System.out.println(libroNuevo);
		
		//Confirmar Operación
		if(confirmar()) {
			libroNuevo.setDescripcion(descripcionNueva);
			inventario.addLibro(libroNuevo);
			System.out.println("\nEl libro ha sido agregado.");
		} else {
			System.out.println("\nEl libro no ha sido agregado.");
			return;
		}
			
		Console.readLine();		   		
	
	}
	
	public static void eliminarLibro() {
		
		System.out.println(">>>>>>>>>>Eliminar-Libro<<<<<<<<<<\n");
		
		//Muestra una lista con todos los libros en el inventario
		int numLib = selectLibro();
		
		//Si no se selecciona nada salimos
		if(numLib == -1) {
			Console.readLine("Operacion cancelada");
		} else {
			//Pedimos confirmar la operación
			if(confirmar()) {
				inventario.removeLibro(numLib);
				Console.readLine("El libro ha sido eliminado");
			} else {
				Console.readLine("Operacion Cancelada");
			}
		}
		
	}
	
	public static void buscarLibro() {
		
		System.out.println(">>>>>>>>>>Buscar-Libro<<<<<<<<<<\n");
		
		DescripcionLibro descripcionBuscada = new DescripcionLibro();
		
		//Titulo-----
		descripcionBuscada.setTitulo(selectTitulo());
		//Autor-----
		descripcionBuscada.setAutor(selectAutor());
		//Editorial-----
		descripcionBuscada.setEditorial(selectEditorial());
		//Formato
		descripcionBuscada.setFormato(selectFormato());
		//Edición
		descripcionBuscada.setEdicion(selectEdicion());
		
		List resultados = inventario.buscar(descripcionBuscada);
		
		//No se encontraron resultados
		if(resultados.isEmpty()){
			System.out.println("No se han encontrado resultados para:\n" +
								descripcionBuscada);
			Console.readLine();
			return;
		}
		
		System.out.println("Se-han-encontrado-los-siguientes resultados" +
			"-------------------------------------");
		Console.readLine();
		for(Iterator i = resultados.iterator(); i.hasNext();) {
			
			Libro libro = (Libro) i.next();
			DescripcionLibro descripcion = libro.getDescripcion();
			
			System.out.println(descripcion);
			System.out.println("--------------------------------------------");
		}
		
		Console.readLine();
	}
	
	public static void modificarLibro() {
		
		Libro libroViejo = null;
		DescripcionLibro descripcionVieja = null;
		Libro libroNuevo = new Libro();
		DescripcionLibro descripcionNueva = libroNuevo.getDescripcion();
		
		System.out.println(">>>>>>>>>>>>>>>Modificar-Libro<<<<<<<<<<<<<<<");
		
		//Si se selecciona algo lo asignamos, si no, salimos
		int indice = selectLibro();
		if(indice != -1) {
			libroViejo = inventario.getLibro(indice);
			descripcionVieja = libroViejo.getDescripcion();
		} else {
			System.out.println("Modificacion cancelada...");
			Console.readLine();
			return;
		}
		
		//Mostramos datos viejos y pedimos datos nuevos
		
		//Título-----
		System.out.println("Titulo: " + descripcionVieja.getTitulo());
		String tituloNuevo = selectTitulo();
		if(!tituloNuevo.equals("")) {
			descripcionNueva.setTitulo(tituloNuevo);
		} else {
			descripcionNueva.setTitulo(descripcionVieja.getTitulo());
		}
		//Autor-----
		System.out.println("Autor: " + descripcionVieja.getAutor());
		String autorNuevo = selectAutor();
		if(!autorNuevo.equals("")) {
			descripcionNueva.setAutor(autorNuevo);
		} else {
			descripcionNueva.setAutor(descripcionVieja.getAutor());
		}
		//Editorial-----
		System.out.println("Editorial: " + descripcionVieja.getEditorial());
		Editorial editorialNueva = selectEditorial();
		if(editorialNueva != null) {
			descripcionNueva.setEditorial(editorialNueva);
		} else {
			descripcionNueva.setEditorial(descripcionVieja.getEditorial());
		}
		//Formato
		System.out.println("Formato: " + descripcionVieja.getFormato());
		Formato FormatoNuevo = selectFormato();
		if(FormatoNuevo != null) {
			descripcionNueva.setFormato(FormatoNuevo);
		} else {
			descripcionNueva.setFormato(descripcionVieja.getFormato());
		}
		//ISBN
		System.out.println("ISBN: " + libroViejo.getIsbn());
		String isbnNuevo = selectIsbn();
		if(!isbnNuevo.equals("")) {
			libroNuevo.setIsbn(isbnNuevo);
		} else {
			libroNuevo.setIsbn(libroViejo.getIsbn());
		}
		//Páginas
		System.out.println("Paginas: " + libroViejo.getPaginas());
		int paginasNuevas = selectPaginas();
		if(paginasNuevas != 0) {
			libroNuevo.setPaginas(paginasNuevas);
		} else {
			libroNuevo.setPaginas(libroViejo.getPaginas());
		}
		//Edición
		System.out.println("Edicion: " + descripcionVieja.getEdicion());
		int edicionNueva = selectEdicion();
		if(edicionNueva != 0) {
			descripcionNueva.setEdicion(edicionNueva);
		} else {
			descripcionNueva.setEdicion(descripcionVieja.getEdicion());
		}
		//Sinopsis
		System.out.println("Sinopsis: " + libroViejo.getSinopsis());
		String sinopsisNueva = selectSinopsis();
		if(!sinopsisNueva.equals("")) {
			libroNuevo.setSinopsis(sinopsisNueva);
		} else {
			libroNuevo.setSinopsis(libroViejo.getSinopsis());
		}

		System.out.println(">>>Confirme los siquientes datos------");
		Console.readLine();
		System.out.println(libroNuevo);
		
		//Confirmamos la operación
		if(confirmar()) {
			inventario.setLibro(indice, libroNuevo);
		} else {
			System.out.println("Operacion cancelada");
			Console.readLine();
		}
		
	}
	
	public static void listarLibros() {
		
		List libros = inventario.getLibros();
		
		for(int i = 0; i < libros.size(); i++) {
			Libro libro = (Libro)libros.get(i);
			DescripcionLibro descripcion = libro.getDescripcion();
			
			
			System.out.println("\n" + i + ")_________________________________" +
			"______________________________" +
							   descripcion);
		}
		
		System.out.println(
			"================================================================");
	}
	
	
	//Funciones-Auxiliares------------------------------------------------------
	
	private static int selectLibro() {
			
		listarLibros();
		
		while(true) {
			
			String entrada = Console.readLine(
				"Seleccione un libro o deje en blanco para omitir");
			
			int numLib = -1;
			
			if(entrada.equals("")) {
				return -1;
			}
			
			try{
				numLib = Integer.parseInt(entrada);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			if(numLib >= 0 && numLib < inventario.length()) {
				//Muestra el libro seleccionado
				Libro libro = inventario.getLibro(numLib);
				DescripcionLibro descripcion = libro.getDescripcion();
				System.out.println(">>>>>>>>>>>>>Libro-Seleccionado<<<<<<<<<<<<<");
				System.out.println(descripcion);
				
				System.out.println("-----------------------------------------");
				
				return numLib;
			}
			
		}
	}
	
	private static String selectTitulo() {
		String titulo = "";
		titulo = Console.readLine("Ingrese el [Titulo]" + 
									"\no deje en blanco para ignorar.");
		return titulo;
	}
	
	private static String selectAutor() {
		String autor = "";
		autor = Console.readLine("Ingrese el [Autor]" +
									"\no deje en blanco para ignorar.");
		return autor;
	}
	
	private static Editorial selectEditorial() {
		int indice = -1;
		
		while(true) {
			
			indice = -1;
			Console.println(
				"Introduza el numero de la [Editorial] correspondiente" +
				"\no deje en blanco para ignorar.");
			
			//Imprimimos las editoriales
			int i = 0;
			for(Editorial e: Editorial.values()){
				System.out.println("\t" + i + ".-" + e);
				i++;
			}
			
			String ed = Console.readLine();
			
			//Si no se ingresa nada salimos
			if(ed.equals("")) {
				return null;
			}
			
			//Checamos que sea número
			try {
				indice = Integer.parseInt(ed);
			} catch(NumberFormatException nfe) {
				//Ignore this thang, mate
			}
			
			//Checamos que esté dentro del rango del índice
			if(indice>=0 && indice < Editorial.size) {
				return Editorial.values()[indice];
			}
			
		}
		
	}
	
	private static Formato selectFormato() {
		int indice = -1;
		
		while(true) {
			
			indice = -1;
			Console.println(
				"\nIntroduza el numero del [Formato] correspondiente" +
				"\no deje en blanco para ignorar.");
			
			//Imprimimos los Formatos
			int i = 0;
			for(Formato f: Formato.values()){
				System.out.println("\t" + i + ".-" + f);
				i++;
			}
			
			String fo = Console.readLine();
			
			//Si no se ingresa nada salimos
			if(fo.equals("")) {
				return null;
			}
			
			//Checamos que sea número
			try {
				indice = Integer.parseInt(fo);
			} catch(NumberFormatException nfe) {
				//Ignore this thang, mate
			}
			
			//Checamos que esté dentro del rango del índice
			if(indice>=0 && indice < Formato.size) {
				return Formato.values()[indice];
			}
			
		}
		
	}
	
	private static int selectEdicion() {
		
		int edicion = 0;
		
		while(true)	{
			
			edicion = 0;
			
			String edicionS = Console.readLine("\nIngrese la [Edicion]" +
											"\no deje en blanco para ignorar.");
			
			if(edicionS.equals("")) {
				return 0;
			} else {	
				
				try {
					edicion = Integer.parseInt(edicionS);
				} catch(NumberFormatException nfe) {
					//Do nothing
				}
				
				if(edicion > 0) {
					return edicion;
				}
				
			}
			
		}
		
	}
	
	private static String selectIsbn() {
		
		String isbn;
		
		while(true) {
			
			isbn = Console.readLine("\nIngresa el [ISBN]" +
									"\no deje en blanco para ignorar.");
			
			//Si no está vacío y contiene 10 o 13 carácteres
			if(!isbn.equals("") ) {
				
				if(isbn.replace("-","").length() == 10 || 
				   isbn.replace("-","").length() == 13 ) {
				   	return isbn;
				}
				
			} else {
				return "";
			}
		}
	}
	
	private static int selectPaginas() {
		
		int paginas = 0;
		
		while(true)	{
			
			paginas = 0;
			
			String numS = Console.readLine("\nIngrese el numero de [paginas]" +
											"\no deje en blanco para ignorar.");
			
			if(!numS.equals("")) {
				
				try {
					paginas = Integer.parseInt(numS);
				} catch(NumberFormatException nfe) {
					//Do nothing
				}
				
			} else {
				return 0;
			}
			
			if(paginas >= 0) {
				 return paginas;
			}
		}
	}
	
	private static String selectSinopsis() {
		return Console.readLine("Ingrese la [Sinopsis]" +
									"\no deje en blanco para ignorar.");
	}
	
	private static boolean confirmar() {
			
		while(true) {
			
			String resp = Console.readLine("\nConfirmar operacion? (S/N)");
			
			if(resp.equalsIgnoreCase("s")) {
										 
				return true;
				
			} else if(resp.equalsIgnoreCase("n")) {
				
				return false;
			} 
			
		}			
	}
}