import java.io.*;

public class Console {
	
	static StringBuilder response = new StringBuilder("");
	//Imprime el texto recibido en la consola
	public static void println(String text) {
		
		System.out.println(text);
		
	}
	//Lee lo introducido en la consola evitando el uso de un try/catch
	public static String readLine() {
		
		BufferedReader bf = new
			BufferedReader(new InputStreamReader(System.in));
		
		response.delete(0, response.length());
		
		try{
			response.append(bf.readLine());
		} catch(IOException ex) {
			System.out.println("Excpetion: " + ex.getMessage());
			return null;
		}
		
		return response.toString();
		
	}
	
}