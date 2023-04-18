
import java.io.*;
import java.util.regex.*;

class lab6 {
	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#\\.(\\d+)g");
		Matcher matcher = pattern.matcher(formatString);

		if (!matcher.find()) {
			System.out.println(formatString);
			return;
		}
		
		String number = matcher.group(1);
		int num = 0;
		
		try {
			num = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println(formatString);
			return;
		}

		int val = 0;

		try {
			val = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			System.out.println(formatString);
			return;
		}

		String replaceWith = String.format("%0" + num + "d", Math.abs(val))
				.chars()
				.map(Character::getNumericValue)
				.map(c -> (c * 9 + 1) % 10)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();

		if (val < 0)
			replaceWith = "-" + replaceWith;

		System.out.println(formatString.replace(matcher.group(0), replaceWith));
	
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
