public enum Formato {
	
	TAPA_DURA("tapa dura"),
	RUSTICO("r�stico");
	
	private String nombre;
	
	Formato(String  nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}
	
};