
import java.io.*;
import java.util.HashMap;

class lab7 {
	
	private static final HashMap<Character, Character> replacements = new HashMap<>() {{
		put('a', 'g');
		put('b', 'h');
		put('c', 'i');
		put('d', 'j');
		put('e', 'k');
		put('f', 'l');
	}};

	public static void my_printf(String format_string, String param){
		
		System.out.println("");
	}

	public static void main(String[] args) throws IOException {
		//System.out.println("Hello, World!"); 
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		String format_string, param;
		while(bufferReader.ready()) {
			format_string=bufferReader.readLine();
			param=bufferReader.readLine();
			my_printf(format_string,param);
		}
	}
}
