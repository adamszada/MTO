
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class lab11 {
	static String replacements =  "abcdefghij";

	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#b");
		Matcher matcher = pattern.matcher(format_string);
		if (!matcher.find()) {
			System.out.println(format_string);
			return;
		}

		int tmpNumber  = 0;
		try {
			tmpNumber  = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			System.out.println(format_string);
			return;
		}
	
		String replacement = Integer.toBinaryString(tmpNumber);
		StringBuilder replaceStringBuilder = new StringBuilder();

		for (int i = 0; i < replacement.length(); i++) {
			char num = replacement.charAt(replacement.length() - 1 - i);
			if (num == '0') {
				replaceStringBuilder.append('0');
			} else {
				replaceStringBuilder.append(replacements.charAt(i % 10));
			}
		}

		replacement = replaceStringBuilder.reverse().toString();
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
