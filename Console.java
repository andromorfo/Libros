import java.io.*;

public class Console {
	
	static StringBuilder response = new StringBuilder("");
	
	public static void println(String text) {
		
		System.out.println(text);
		
	}
	
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