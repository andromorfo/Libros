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
		
			System.out.println("\nSeleccione una opcion:" +
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
			System.out.println("\n\nAgregar libro? (S/N)");
			
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
		System.out.println("Seleccione el numero de libro que desea eliminar");
		Console.readLine();
		
		//Muestra una lista con todos los libros en el inventario
		listarLibros();
		
		cicloEliminar:
		while(true) {
			System.out.print("Marque c si desean cancelar"+
			"\n\nQue libro desea eliminar?: ");
			
			String opcion = Console.readLine();
			int numLib = -1;
			
			if(opcion.equalsIgnoreCase("c")) {
				return;
			} else {
				try {
					numLib = Integer.parseInt(opcion);
				} catch(NumberFormatException nfe) {
				}
				
				if(numLib != -1) {
					
					System.out.print("\nDesea eliminar el libro?:\n" +
						inventario.getLibro(numLib) +
						"\n\n(S/N):");
					
					if(Console.readLine().equalsIgnoreCase("s")) {
						inventario.removeLibro(numLib);
						System.out.println("\nEl libro ha sido eliminado");
						Console.readLine();
						return;
					} else {
						System.out.println("\nEliminacion cancelada");
						Console.readLine();
						return;
					}
				}
				
			}
		}
		
		
		
		
		
	}
	
	public static void buscarLibro() {
		
		String  titulo, autor;
		Editorial editorial = null;
		Formato formato = null;
		int edicion = -1, indice = 0;
		
		//Título
		titulo = Console.readLine("\nIntroduzca el <titulo> del libro o deje " +
								  "blanco para ignorar.");
		//Autor
		autor = Console.readLine("\nIntroduzca el <autor> del libro o deje " +
								 "en blanco para ignorar.");
		//Editorial
		cicloEditorial:
		while(true) {
			indice = 0;
			Console.println("\nIntroduza el numero de la <editorial> " +
															"correspondiente");
			//Imprime las editoriales junto a un índice
			for(Editorial e: Editorial.values()){
			System.out.println("\t" + indice + ".-" + e);
			indice++;
			}
			
			String ed = Console.readLine();
			if(ed.equals("")){
				break cicloEditorial;
			}
			
			try {
				indice = Integer.parseInt(ed);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			if(indice>=0 && indice < Editorial.values().length) {
				editorial = Editorial.values()[indice];
				break cicloEditorial;
			}
			
		}
		
		//Formato
		cicloFormato:
		while(true) {
			indice = 0;
			Console.println("\nIntroduza el numero del <formato> " +
															"correspondiente");
			
			for(Formato e: Formato.values()){
			System.out.println("\t" + indice + ".-" + e);
			indice++;
			}
			
			String fo = Console.readLine();
			if(fo.equals("")) {
				break cicloFormato;
			}
			
			try {
				indice = Integer.parseInt(fo);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			if(indice>=0 && indice < Formato.values().length) {
				formato = Formato.values()[indice];
				break cicloFormato;
			}
			
		}
		
		
		//Edicion
		cicloEdicion:
		while(true) {
			String ed = Console.readLine("Introduzca en <numero> de edicion " +
										 "o deje en blanco para ingorar.");
			if(ed.equals("")) {
				break cicloEdicion;
			}
			
			try {
				edicion = Integer.parseInt(ed);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			break cicloEdicion;
		}
		
		DescripcionLibro descripcion = new
			DescripcionLibro(titulo, autor, editorial, formato, edicion);
		
		
		//Muestra los resultados, si es que los hay
		List resultados = inventario.buscar(descripcion);
		
		if(!resultados.isEmpty()) {
			System.out.println(">>>>>>Se_han_encontrado_los_siguientes_libros" +
							   "<<<<<<");
		} else {
			System.out.println("No se han encontrado libros");
			Console.readLine();
		}
		
		for(Iterator i = resultados.iterator(); i.hasNext();) {
			Libro libro = (Libro)i.next();
			System.out.println(libro);
		}
		
		System.out.println("-----------------");
		Console.readLine();
		
	}
	
	public static void modificarLibro() {
		
		Libro libroViejo;
		DescripcionLibro descripcionVieja;
		String autor, titulo,isbn, sinopsis;
		Editorial editorial = null;
		Formato formato = null;
		int edicion = -1, paginas = -1, indice, indiceL;
		
		
		System.out.println(">>>>>>" + 
			"Seleccione el numero de libro que desea modificar" +
			"<<<<<<");
		Console.readLine();
		
		//Muestra una lista con todos los libros en el inventario
		listarLibros();
		
		//Slecciona un libro
		cicloSelectLibro:
		while(true) {
			try {
				indice = Integer.parseInt(
						Console.readLine("Numero de Libro:"));
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			if(indice >=0 && indice <= inventario.length()) {
				libroViejo = (Libro)inventario.getLibro(indice);
				descripcionVieja = libroViejo.getDescripcion();
				indiceL = indice;
				break cicloSelectLibro;
			} else {
				continue;
			}
			
		}
		
		//Titulo
		System.out.print("\nTitulo antiguo: " + descripcionVieja.getTitulo());
		titulo = Console.readLine(
			"\n>>>Ingrese titulo nuevo (Dejar en blanco para omitir)");
		if(titulo.equals("")){
			titulo = descripcionVieja.getTitulo();
		}
		
		//Autor
		System.out.print("\nAutor antiguo: " + descripcionVieja.getAutor());
		autor = Console.readLine(
			"\n>>>Ingrese el autor nuevo (Dejar en blanco para omitir)");
		if(autor.equals("")) {
			autor = descripcionVieja.getAutor();
		}
		
		//Editorial
		cicloEditorial:
		while(true) {
			indice = 0;
			Console.println("\nEditoriales----------------------------");
			//Imprime las editoriales junto a un índice
			for(Editorial e: Editorial.values()){
			System.out.println("\t" + indice + ".-" + e);
			indice++;
			}
			
			String ed = Console.readLine("Introduzca el numero " +
				"de la [Editorial] o deje en blanco para omitir");
			
			if(ed.equals("")){
				break cicloEditorial;
			}
			
			try {
				indice = Integer.parseInt(ed);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			if(indice>=0 && indice < Editorial.values().length) {
				editorial = Editorial.values()[indice];
				break cicloEditorial;
			}
			
		}
		if(editorial == null) {
			editorial = descripcionVieja.getEditorial();
		}
		
		//Formato
		cicloFormato:
		while(true) {
			
			//Imprime los Formatos junto a un índice
			indice = 0;
			Console.println("\nFormatos----------------------------");
			for(Formato f: Formato.values()){
			System.out.println("\t" + indice + ".-" + f);
			indice++;
			}
			
			String fo = Console.readLine("Introduzca el numero " +
				"del [Formato] o deje en blanco para omitir");
			
			//Si está vacío salimos
			if(fo.equals("")){
				break cicloFormato;
			}
			
			//Si causa error no es un número válido
			try {
				indice = Integer.parseInt(fo);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			//Si el número está entre el índice asignamos su objeto
			if(indice>=0 && indice < Formato.values().length) {
				formato = Formato.values()[indice];
				break cicloFormato;
			}
			
		}
		//Si no se selecciono nada asignamos el valor anterior
		if(formato == null) {
			formato = descripcionVieja.getFormato();
		}
		
		
		//Edicion
		cicloEdicion:
		while(true) {
			String ed = Console.readLine("Introduzca en <numero> de edicion " +
										 "o deje en blanco para ingorar.");
			if(ed.equals("")) {
				break cicloEdicion;
			}
			
			try {
				edicion = Integer.parseInt(ed);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			break cicloEdicion;
		}
		
		if(edicion == -1) {
			edicion = descripcionVieja.getEdicion();
		}
		
		
		//ISBN
		cicloIsbn:
		while(true) {
			
			isbn = Console.readLine("Introduzca el <ISBN> o deje en blanco " +
									"para ignorar.");
			
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
		if(isbn.equals("")) {
			isbn = libroViejo.getIsbn();
		}
		
		//Núm Páginas
		cicloPaginas:
		while(true) {
			String pag = Console.readLine("Introduzca en numero de <Paginas> " +
										 "o deje en blanco para ingorar.");
			if(pag.equals("")) {
				break cicloPaginas;
			}
			
			try {
				paginas = Integer.parseInt(pag);
			} catch(NumberFormatException nfe) {
				continue;
			}
			
			break cicloPaginas;
		}
		
		if(paginas == -1) {
			paginas = libroViejo.getPaginas();
		}
		
		//Sinopsis
		System.out.println(">>>Sinopsis vieja<<<\n" + libroViejo.getSinopsis());
		sinopsis = Console.readLine("\nIntroduzca la nueva <sinopsis>, o " +
									"deje en blanco para omitir.");
		if(sinopsis.equals("")) {
			sinopsis = libroViejo.getSinopsis();
		}
		
		//Mostrar los datos
		System.out.println("Revise los datos-----------" +
							"\nTitulo: " + titulo +
							"\nAutor: " + autor +
							"\nEditorial: " + editorial +
							"\nFormato: " + formato +
							"\nEdicion: " + edicion +
							"\nIsbn: " + isbn +
							"\nNum de Paginas: " + paginas +
							"\nSinopsis: ");
		//Imprime resumen de la sinopsis
		System.out.print( (sinopsis.length() < 50)? 
								sinopsis.substring(0, sinopsis.length()) :
								sinopsis.substring(0, 50) );
		System.out.print("...");
		
		
		//Agregar?
		while(true) {
			System.out.println("\n\nModificar Libro? (S/N)");
			
			String resp = Console.readLine();
			
			if(resp.equalsIgnoreCase("s")) {
				
				Libro libroNuevo = new Libro(isbn, paginas, sinopsis,
					new DescripcionLibro(titulo, autor, editorial, formato,
										 edicion));
				
				inventario.replaceLibro(indiceL, libroNuevo);
				
				System.out.println("\nEl libro ha sido modificado.");
				return;
				
			} else if(resp.equalsIgnoreCase("n")) {
				
				System.out.println("\nEl libro no ha sido modificado.");
				return;
				
			} 
			
			
		}
		
		
	}
	
	public static void listarLibros() {
		System.out.println("\nLibros Dentro del Inventario----------");
		
		List libros = inventario.getLibros();
		
		for(int i = 0; i < libros.size(); i++) {
			Libro libro = (Libro)libros.get(i);
			
			System.out.println(i + ")_____________" +
							   libro + "\n");
			
		}
		
		System.out.println("------------------------");
	}
	
}