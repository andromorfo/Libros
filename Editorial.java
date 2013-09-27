public enum Editorial {
	
	SALAMANDRA("Publicaciones y Ediciones Salamandra, S.A."),
	EDITORES_MEXICANOS_UNIDOS("Editores Mexicanos Unidos, S.A."),
	ALMUZARA("Editorial Almuzara"),
	PORRUA("Editorial Porrúa, SA de CV"),
	TOMO("Grupo Editorial Tomo, S.A. de C.V."),
	PLAZA_Y_JANES("Plaza & Janés, S.A., Editores"),
	EPOCA("Editorial Época, S.A. de C.V.");
	
	private String nombre;
	
	Editorial(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre;
	}
};