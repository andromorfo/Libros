public class Test {
	
	public static void main(String[] args) {
		
		Libro libro = new Libro("1234567890", 90, 
			"Un libro que trata de...",
			new DescripcionLibro("Harry Potter", "J.K. Rowling",
								Editorial.TOMO, Formato.RUSTICO, 1));
		
		System.out.println(libro);
		
	}
	
	
}