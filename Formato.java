public enum Formato {
	
	TAPA_DURA("Tapa Dura"),
	RUSTICO("Rustico");
	
	private String nombre;
	public static final int size = Formato.values().length;
	
	Formato(String  nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}
	
};