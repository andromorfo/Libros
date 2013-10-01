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
			"Las tediosas vacaciones de verano en casa de sus t�os todav�a " +
			"no han acabado y Harry se encuentra m�s inquieto que nunca. " +
			"Apenas ha tenido noticias de Ron y Hermione, y presiente que " +
			"algo extra�o est� sucediendo en Hogwarts. En efecto, cuando por " +
			"fin comienza otro curso en el famoso colegio de magia y " +
			"hechicer�a, sus temores se vuelven realidad.\nEl ministerio de " +
			"magia niega que Voldemort haya regresado y ha iniciado una " +
			"campa�a de desprestigio contra Harry y Dumbledore, para lo cual " +
			"ha asignado a la horrible profesora Dolores Umbridge la tarea " +
			"de vigilar todos sus movimientos. As� pues, adem�s de sentirse " +
			"solo e incomprendido, Harry sospecha que Voldemort puede " +
			"adivinar sus pensamientos, e intuye que el temible mago trata " +
			"de apoderarse de un objeto secreto que le permitir�a recuperar " +
			"su poder destructivo.",
				new DescripcionLibro("Harry Potter y la Orden del F�nix",
								 "J.K. Rowling", Editorial.SALAMANDRA,
								 Formato.TAPA_DURA, 1));
		
		addLibro("978-607-14-1116-7", 200,
			"El doctor V�ctor Frankenstein ha descubierto el secreto para " +
			"dar vida a la materia muerta y ha creado, pieza por pieza, a " +
			"un nuevo ser. Tras observar la imperfecci�n y torpeza de su " +
			"creaci�n, el doctor la rechaza, provocando en ella una gran " +
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
			"sobreponerse a la visi�n desesperanzada de un mundo colapsado " +
			"por la Primera Guerra Mundial. El conflicto b�lico dej� el " +
			"amargo sabor del desencanto y conmocion� la conciencia " + 
			"occidental. Con los ojos vueltos hacia el Oriente, Hesse " +
			"encontr� en el brahmanismo y el budismo de la India la " +
			"posibilidad de acceder a ciertas modalidades del conocimiento " +
			"para enriquecer la vida interior. Se convenci� de que toda " +
			"b�squeda espiritual inicia dentro de nosotros mismos.\n\n" +
			"Siddharta (1922), basada en la vida del joven Buda, llega a la" +
			"conclusi�n de que todo en la vida es apariencia: se puede " +
			"comunicar el saber, pero no la sabidur�a. S�lo as� se est� en " +
			"camino de la perfecci�n tan anhelada.",
			new DescripcionLibro("Siddharta", "Hermann Hesse",
								 Editorial.EDITORES_MEXICANOS_UNIDOS,
								 Formato.TAPA_DURA, 1));
					
		addLibro("978-607-7835-61-5", 464,
			"Max Brooks ha dedicado varios a�os a recorrer el mundo en busca " +
			"de todos los testimonios que ahora re�ne aqu� sobre la guerra " +
			"mundial zombi. Por ins�lito que parezca este libro, que algunos " +
			"tildan de novela demasiado realista, es la parte censurada del " +
			"informe que le encarg� Naciones Unidas para que quedara memoria " +
			"de <<La Crisis>>, <<Los A�os Oscuros>> o la <<Plaga Andante>>, " +
			"principalmente conocida como Guerra Mundial Z. Al parecer hab�a " +
			"<<demasiado factor humano>>.\n\tEste libro aclara realmente " +
			"c�mo el doctor Kwang Jingshu descubri� los primeros casos y se " +
			"destaparon las pruebas ocultadas por el gobierno chino sobre " +
			"el gran estallido. Tambi�n c�mo surgi� y se propag� el " +
			"controvertido Plan Naranja de supervivencia, fruto de un oscuro " +
			"cerebro del apartheid sudafricano. Adem�s contiene los " +
			"testimonios directos de gentes de la posguerra: contrabandistas " +
			"del T�bet, oficiales de servicios secretos de medio mundo, " +
			"militares, cient�ficos, industriales, pol�ticos, ecologistas " +
			"supermodelos, gentes de culturas alternativas tras el " +
			"cataclismo y muchos otros que lucharon para defendernos de la " +
			"amenaza de los zombis. Tambi�n de aquellos que no lo hicieron " +
			"tanto e incluso de aquellos que creen que la lucha contin�a.\n" +
			"\nPor fin, el mundo sabr� la historia verdadera de c�mo la " +
			"humanidad estuvo a punto de extinguirse. Desde el fin oficial " +
			"de las hostilidades se han producido numerosas tentativas para " +
			"documentar la guerra zombi. Guerra Mundial Z es el relato " +
			"definitivo -realizado por los propios supervivientes- de los " +
			"detalles tecnol�gicos, militares, sociales, econ�micos, y " +
			"pol�ticos de c�mo la civilizaci�n estuvo al borde de la " +
			"extinci�n en la lucha total contra el muerto viviente.",
			new DescripcionLibro("GUERRA MUNDIAL Z. UNA HISTORIA ORAL DE LA" +
								 " GUERRA ZOMBI", "Max Brooks",
								 Editorial.ALMUZARA, Formato.RUSTICO, 1));
		
		
		addLibro(null, 206,
			"La cultura cient�fica, literaria y art�stica de Huxley, unida " +
			"a su extraordinaria lucidez y punzante iron�a, le permiten " +
			"trazar en esta novela el esquema de un mundo feliz, sin " +
			"sufrimiento f�sico, aunque sin iniciativa ni libertad " +
			"individual. La vida mecanizada origina un Estado en el que todo " +
			"lo resuelve la ciencia, donde los ciudadanos disconformes son " +
			"tratados como enfermos. Ambientado en un Londres ut�pico, " +
			"gigantesco y de atrevidas l�neas futuristas, este libro, " +
			"escrito con un estilo claro, es una sat�rica pintura de un " +
			"porvenir no imposible. Desde la aparici�n de su primera " +
			"edici�n inglesa, UN MUNDO FELIZ ha sido considerada una de las " +
			"novelas m�s importantes de nuestro tiempo.",
			new DescripcionLibro("Un mundo feliz", "Aldous Huxley",
								 Editorial.PLAZA_Y_JANES, Formato.TAPA_DURA,
								 -1));
						
		addLibro("970-627-200-1", 256,
			"En esta novela ut�pica, Aldous Huxley abre una ventana por la " +
			"que podremos tener un atisbo de un mundo feliz. Los seres " +
			"humanos son creados en probetas y en serie; y desde que son " +
			"fecundados se decide a qu� grupo pertenecer�n: si ser�n Gamma, " +
			"Beta... o pertenecer�n al grupo Alpha, el de los cient�ficos, " +
			"los bellos, lo mejor y que son quienes deciden el futuro del " +
			"planeta.\nTodos son felices porque desde que vienen al mundo " +
			"se les condiciona, a trav�s del sue�o, a aceptar la existencia " +
			"que les toca y no desear nada m�s./nNo existe la guerra, ni el " +
			"hambre... aparentemente lo �nico que hay es felicidad.\nPero, " +
			"�realmente son felices? Esto lo viene a cuestionar John, un " +
			"singular personaje, extra�do de una reservaci�n en la que viven " +
			"\"los salvajes\", que son aquellos que todav�a conservan " +
			"costumbres tan antiguas como tener padres y reverenciar a la " +
			"muerte.\nMuchas son las interrogantes que plantea esta " +
			"espendida novela, que ha pasado a formar parte del acervo " +
			"intelectual de la humanidad.",
			new DescripcionLibro("Un mundo feliz", "Aldous Huxley",
								 Editorial.EPOCA, Formato.RUSTICO, -1));
		
		addLibro("970-666-777-6", 192,
			"Tan importantes como los relatos sobre los \"Mitos de Cthulhu\" " +
			"son las encantadoras narraciones que Lovecraft nos dej� sobre " +
			"el mundo de los sue�os./n/n/tAunque el escritor de Providence " +
			"no era en absoluto aficionado a repetir personajes, con " +
			"Randolph Carter hizo una excepci�n. El ciclo de sus aventuras" +
			"consta de tres relatos(La Declaraci�n de Randolph Carter, La " +
			"Llave de Plata, A Trav�s de las Puertas de la Llave de Plata) " +
			"y la novela corta que tienes en tus manos, una alucinaci�n " +
			"on�rica que Lovecraft comenz� a escribir e 1920 y que fue " +
			"publicada siete a�os despu�s.\n\n\tAaparecen aqu� los " +
			"Primigenios (llamados \"Los Otros Dioses\"), Azatoth, " +
			"Nyarlathotep, los Shantaks, los Ghules y los Dholes, los " +
			"�ngeles descarnados de la noche... criaturas que aparecene en " +
			"el ciclo de los \"Mitos de Cthulhu\" de una manera m�s cruda " +
			"y racionalista, aqu� se muestran como simples monstruos o " +
			"presencias siniestras de las que se puede escapar.",
			new DescripcionLibro("La b�squeda so�ada de la oculta Kadath",
								 "H.P. Lovecraft", Editorial.TOMO,
								 Formato.RUSTICO, 2));
		
	}
	
}