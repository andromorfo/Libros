public class DescripcionLibro {
	
	private String titulo;
	private String autor;
	private Editorial editorial;
	private Formato formato;
	private int edicion;
	
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
	
	public String getAutor() {
		return autor;
	}
	
	public Editorial getEditorial() {
		return editorial;
	}
	
	public Formato getFormato() {
		return formato;
	}
	
	public int getEdicion() {
		return edicion;
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
			if((edicion != -1) && (edicion != this.edicion))
				return false;
			
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public String toString() {
		
		String edicion = (getEdicion() != -1)? "" + getEdicion():"n/a";
		
		return "\nTítulo: " + getTitulo() +
			   "\nAutor: " + getAutor() +
			   "\nEditorial: " + getEditorial() +
			   "\nFormato: " + getFormato() +
			   "\nEdicion: " + edicion;
			   
	}
	
}