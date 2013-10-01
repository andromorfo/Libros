import java.util.*;

public class Inventario {
	
	private List libros;
	
	public Inventario() {
		libros = new LinkedList();
		inicializaInventario();
	}
	
	public void addLibro(String isbn, int paginas,
						 String sinopsis, DescripcionLibro descripcion) {
		
		Libro libro = new Libro(isbn, paginas, sinopsis, descripcion);
		libros.add(libro);
	}
	
	public Libro getLibro(String isbn) {
		
		for(Iterator i = libros.iterator(); i.hasNext();) {
			
			Libro libro = (Libro)i.next();
			
			if(isbn.equals(libro.getIsbn())) {
				return libro;
			}
			
		}
		
		return null;
	}
	
	public Libro getLibro(int indice) {
		
		return (Libro)libros.get(indice);
		
	}
	
	public List buscar(DescripcionLibro descLibroBuscado) {
		
		List librosEncontrados = new LinkedList();
		
		for(Iterator i = libros.iterator(); i.hasNext();) {
			Libro libro = (Libro)i.next();
			DescripcionLibro descripcion = libro.getDescripcion();
			
			if(!descripcion.coincide(descLibroBuscado))
				continue;
			
			librosEncontrados.add(libro);
		}
		
		return librosEncontrados;
		
	}
	
	public List getLibros() {
		return libros;
	}
	
	public void removeLibro(int indice) {
		libros.remove(indice);
	}
	
	public void replaceLibro(int indice, Libro nuevoLibro) {
		libros.set(indice, nuevoLibro);
	}
	
	public int length() {
		
		return libros.size();
		
	}
	
	private void inicializaInventario() {
		
		addLibro("84-7888-744-X", 896,
			"Las tediosas vacaciones de verano en casa de sus tíos todavía " +
			"no han acabado y Harry se encuentra más inquieto que nunca. " +
			"Apenas ha tenido noticias de Ron y Hermione, y presiente que " +
			"algo extraño está sucediendo en Hogwarts. En efecto, cuando por " +
			"fin comienza otro curso en el famoso colegio de magia y " +
			"hechicería, sus temores se vuelven realidad.\nEl ministerio de " +
			"magia niega que Voldemort haya regresado y ha iniciado una " +
			"campaña de desprestigio contra Harry y Dumbledore, para lo cual " +
			"ha asignado a la horrible profesora Dolores Umbridge la tarea " +
			"de vigilar todos sus movimientos. Así pues, además de sentirse " +
			"solo e incomprendido, Harry sospecha que Voldemort puede " +
			"adivinar sus pensamientos, e intuye que el temible mago trata " +
			"de apoderarse de un objeto secreto que le permitiría recuperar " +
			"su poder destructivo.",
				new DescripcionLibro("Harry Potter y la Orden del Fénix",
								 "J.K. Rowling", Editorial.SALAMANDRA,
								 Formato.TAPA_DURA, 1));
		
		addLibro("978-607-14-1116-7", 200,
			"El doctor Víctor Frankenstein ha descubierto el secreto para " +
			"dar vida a la materia muerta y ha creado, pieza por pieza, a " +
			"un nuevo ser. Tras observar la imperfección y torpeza de su " +
			"creación, el doctor la rechaza, provocando en ella una gran " +
			"ira y sed de venganza. A medida que pasa el tiempo, la " +
			"inteligencia de este ser crece y se enfrenta con la desdicha " +
			"de ser considerado un monstruo. Historia que te invita a " +
			"reflexionar sobre la soberbia del hombre y la responsabilidad " +
			"sobre sus actos.",
			new DescripcionLibro("Frankenstein", "Mary W. Shelley",
								 Editorial.EDITORES_MEXICANOS_UNIDOS,
								 Formato.RUSTICO, 1));
		
		addLibro("978- 607-09-0907-8", 304,
			"",
			new DescripcionLibro("Relatos de terror/II", "H.P. Lovecraft",
								 Editorial.PORRUA, Formato.RUSTICO, 1));
					
		addLibro("978-607-14-0397", 128,
			"En la amplia obra de Hermann Hesse destaca Siddharta, novela que" + 
			"condensa el deseo de hallar una senda espiritual para " + 
			"sobreponerse a la visión desesperanzada de un mundo colapsado " +
			"por la Primera Guerra Mundial. El conflicto bélico dejó el " +
			"amargo sabor del desencanto y conmocionó la conciencia " + 
			"occidental. Con los ojos vueltos hacia el Oriente, Hesse " +
			"encontró en el brahmanismo y el budismo de la India la " +
			"posibilidad de acceder a ciertas modalidades del conocimiento " +
			"para enriquecer la vida interior. Se convenció de que toda " +
			"búsqueda espiritual inicia dentro de nosotros mismos.\n\n" +
			"Siddharta (1922), basada en la vida del joven Buda, llega a la" +
			"conclusión de que todo en la vida es apariencia: se puede " +
			"comunicar el saber, pero no la sabiduría. Sólo así se está en " +
			"camino de la perfección tan anhelada.",
			new DescripcionLibro("Siddharta", "Hermann Hesse",
								 Editorial.EDITORES_MEXICANOS_UNIDOS,
								 Formato.TAPA_DURA, 1));
					
		addLibro("978-607-7835-61-5", 464,
			"Max Brooks ha dedicado varios años a recorrer el mundo en busca " +
			"de todos los testimonios que ahora reúne aquí sobre la guerra " +
			"mundial zombi. Por insólito que parezca este libro, que algunos " +
			"tildan de novela demasiado realista, es la parte censurada del " +
			"informe que le encargó Naciones Unidas para que quedara memoria " +
			"de <<La Crisis>>, <<Los Años Oscuros>> o la <<Plaga Andante>>, " +
			"principalmente conocida como Guerra Mundial Z. Al parecer había " +
			"<<demasiado factor humano>>.\n\tEste libro aclara realmente " +
			"cómo el doctor Kwang Jingshu descubrió los primeros casos y se " +
			"destaparon las pruebas ocultadas por el gobierno chino sobre " +
			"el gran estallido. También cómo surgió y se propagó el " +
			"controvertido Plan Naranja de supervivencia, fruto de un oscuro " +
			"cerebro del apartheid sudafricano. Además contiene los " +
			"testimonios directos de gentes de la posguerra: contrabandistas " +
			"del Tíbet, oficiales de servicios secretos de medio mundo, " +
			"militares, científicos, industriales, políticos, ecologistas " +
			"supermodelos, gentes de culturas alternativas tras el " +
			"cataclismo y muchos otros que lucharon para defendernos de la " +
			"amenaza de los zombis. También de aquellos que no lo hicieron " +
			"tanto e incluso de aquellos que creen que la lucha continúa.\n" +
			"\nPor fin, el mundo sabrá la historia verdadera de cómo la " +
			"humanidad estuvo a punto de extinguirse. Desde el fin oficial " +
			"de las hostilidades se han producido numerosas tentativas para " +
			"documentar la guerra zombi. Guerra Mundial Z es el relato " +
			"definitivo -realizado por los propios supervivientes- de los " +
			"detalles tecnológicos, militares, sociales, económicos, y " +
			"políticos de cómo la civilización estuvo al borde de la " +
			"extinción en la lucha total contra el muerto viviente.",
			new DescripcionLibro("GUERRA MUNDIAL Z. UNA HISTORIA ORAL DE LA" +
								 " GUERRA ZOMBI", "Max Brooks",
								 Editorial.ALMUZARA, Formato.RUSTICO, 1));
		
		
		addLibro(null, 206,
			"La cultura científica, literaria y artística de Huxley, unida " +
			"a su extraordinaria lucidez y punzante ironía, le permiten " +
			"trazar en esta novela el esquema de un mundo feliz, sin " +
			"sufrimiento físico, aunque sin iniciativa ni libertad " +
			"individual. La vida mecanizada origina un Estado en el que todo " +
			"lo resuelve la ciencia, donde los ciudadanos disconformes son " +
			"tratados como enfermos. Ambientado en un Londres utópico, " +
			"gigantesco y de atrevidas líneas futuristas, este libro, " +
			"escrito con un estilo claro, es una satírica pintura de un " +
			"porvenir no imposible. Desde la aparición de su primera " +
			"edición inglesa, UN MUNDO FELIZ ha sido considerada una de las " +
			"novelas más importantes de nuestro tiempo.",
			new DescripcionLibro("Un mundo feliz", "Aldous Huxley",
								 Editorial.PLAZA_Y_JANES, Formato.TAPA_DURA,
								 -1));
						
		addLibro("970-627-200-1", 256,
			"En esta novela utópica, Aldous Huxley abre una ventana por la " +
			"que podremos tener un atisbo de un mundo feliz. Los seres " +
			"humanos son creados en probetas y en serie; y desde que son " +
			"fecundados se decide a qué grupo pertenecerán: si serán Gamma, " +
			"Beta... o pertenecerán al grupo Alpha, el de los científicos, " +
			"los bellos, lo mejor y que son quienes deciden el futuro del " +
			"planeta.\nTodos son felices porque desde que vienen al mundo " +
			"se les condiciona, a través del sueño, a aceptar la existencia " +
			"que les toca y no desear nada más./nNo existe la guerra, ni el " +
			"hambre... aparentemente lo único que hay es felicidad.\nPero, " +
			"¿realmente son felices? Esto lo viene a cuestionar John, un " +
			"singular personaje, extraído de una reservación en la que viven " +
			"\"los salvajes\", que son aquellos que todavía conservan " +
			"costumbres tan antiguas como tener padres y reverenciar a la " +
			"muerte.\nMuchas son las interrogantes que plantea esta " +
			"espendida novela, que ha pasado a formar parte del acervo " +
			"intelectual de la humanidad.",
			new DescripcionLibro("Un mundo feliz", "Aldous Huxley",
								 Editorial.EPOCA, Formato.RUSTICO, -1));
		
		addLibro("970-666-777-6", 192,
			"Tan importantes como los relatos sobre los \"Mitos de Cthulhu\" " +
			"son las encantadoras narraciones que Lovecraft nos dejó sobre " +
			"el mundo de los sueños./n/n/tAunque el escritor de Providence " +
			"no era en absoluto aficionado a repetir personajes, con " +
			"Randolph Carter hizo una excepción. El ciclo de sus aventuras" +
			"consta de tres relatos(La Declaración de Randolph Carter, La " +
			"Llave de Plata, A Través de las Puertas de la Llave de Plata) " +
			"y la novela corta que tienes en tus manos, una alucinación " +
			"onírica que Lovecraft comenzó a escribir e 1920 y que fue " +
			"publicada siete años después.\n\n\tAaparecen aquí los " +
			"Primigenios (llamados \"Los Otros Dioses\"), Azatoth, " +
			"Nyarlathotep, los Shantaks, los Ghules y los Dholes, los " +
			"ángeles descarnados de la noche... criaturas que aparecene en " +
			"el ciclo de los \"Mitos de Cthulhu\" de una manera más cruda " +
			"y racionalista, aquí se muestran como simples monstruos o " +
			"presencias siniestras de las que se puede escapar.",
			new DescripcionLibro("La búsqueda soñada de la oculta Kadath",
								 "H.P. Lovecraft", Editorial.TOMO,
								 Formato.RUSTICO, 2));
		
	}
	
}