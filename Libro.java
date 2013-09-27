public class Libro {
	
	private String isbn;
	private int paginas;
	private String sinopsis;
	private DescripcionLibro descripcion;
	
	public Libro(String isbn, int paginas, String sinopsis,
				 DescripcionLibro descripcion) {
		
		this.isbn = isbn;
		this.paginas = paginas;
		this.sinopsis = sinopsis;
		this.descripcion = descripcion;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getPaginas() {
		return paginas;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}
	
	public DescripcionLibro getDescripcion() {
		return descripcion;
	}
	
	@Override
	public String toString() {
		
		return getDescripcion() +
			   "\nPáginas: " + getPaginas() +
			   "\nISBN: " + getIsbn();
		
	}
	
}