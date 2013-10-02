public class DescripcionLibro {
	
	private String titulo;
	private String autor;
	private Editorial editorial;
	private Formato formato;
	private int edicion;
	
	public DescripcionLibro() {
		//Vacío
	}
	
	public DescripcionLibro(String titulo, String autor, Editorial editorial,
					 Formato formato,int edicion) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.formato = formato;
		this.edicion = edicion;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Editorial getEditorial() {
		return editorial;
	}
	
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	public Formato getFormato() {
		return formato;
	}
	
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	public int getEdicion() {
		return edicion;
	}
	
	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
	
	public boolean coincide(DescripcionLibro descripcion) {
		
		if(descripcion != null) {
			
			String titulo = descripcion.getTitulo();
			if((titulo != null) && (!titulo.equals("")) &&
			(!titulo.equalsIgnoreCase(this.titulo))) 
				return false;
			
			String autor = descripcion.getAutor();
			if((autor != null) && (!autor.equals("")) &&
			(!autor.equalsIgnoreCase(this.autor)))
				return false;
			
			Editorial editorial = descripcion.getEditorial();
			if((editorial != null) && (editorial != this.editorial))
				return false;
			
			Formato formato = descripcion.getFormato();
			if((formato != null) && (formato != this.formato))
				return false;
			
			int edicion = descripcion.getEdicion();
			if((edicion != 0) && (edicion != this.edicion))
				return false;
			
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public String toString() {
		
		
		return "\nTitulo: " + getTitulo() +
			   "\nAutor: " + getAutor() +
			   "\nEditorial: " + getEditorial() +
			   "\nFormato: " + getFormato() +
			   "\nEdicion: " + getEdicion();
			   
	}
	
}