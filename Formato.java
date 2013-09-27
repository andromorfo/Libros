public enum Formato {
	
	TAPA_DURA("Tapa Dura"),
	RUSTICO("Rustico");
	
	private String nombre;
	
	Formato(String  nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}
	
};