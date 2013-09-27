public enum Editorial {
	
	SALAMANDRA("Publicaciones y Ediciones Salamandra, S.A."),
	EDITORES_MEXICANOS_UNIDOS("Editores Mexicanos Unidos, S.A."),
	ALMUZARA("Editorial Almuzara"),
	PORRUA("Editorial Porr�a, SA de CV"),
	TOMO("Grupo Editorial Tomo, S.A. de C.V."),
	PLAZA_Y_JANES("Plaza & Jan�s, S.A., Editores"),
	EPOCA("Editorial �poca, S.A. de C.V.");
	
	private String nombre;
	
	Editorial(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}
};