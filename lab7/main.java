
import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Pattern pattern = Pattern.compile("#j");
		Matcher matcher = pattern.matcher(format_string);
		if(!matcher.find()){
			System.out.println(format_string);
			return;
		}
		long tmpNumber;
		try{
			tmpNumber = Long.parseLong(param);
		} catch (NumberFormatException e) {
			System.out.println(format_string);
			return;
		}
		String replacement = Long.toHexString(tmpNumber);
		for (char k : replacements.keySet()) {
			replacement = replacement.replace(k, replacements.get(k));
		}

		System.out.println(format_string.replace(matcher.group(0), replacement));
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
