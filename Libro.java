public class Libro {
	
	private String isbn;
	private int paginas;
	private String sinopsis;
	private DescripcionLibro descripcion;
	
	public Libro() {
		descripcion = new DescripcionLibro();
	}
	
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
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getPaginas() {
		return paginas;
	}
	
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}
	
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	public DescripcionLibro getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(DescripcionLibro descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		
		return getDescripcion() +
			   "\nPaginas: " + getPaginas() +
			   "\nISBN: " + getIsbn() + 
			   "\nSinopsis: " + getSinopsis();
		
	}
	
}