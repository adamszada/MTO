
import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class lab9 {

	private static final HashMap<Character, Character> replacements = new HashMap<>() {{
		put('0', 'a');
		put('1', 'b');
		put('2', 'c');
		put('3', 'd');
		put('4', 'e');
		put('5', 'f');
		put('6', 'g');
		put('7', 'h');
		put('8', 'i');
		put('9', 'j');
	}};


	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#\\.(\\d+)h");
		Matcher matcher = pattern.matcher(format_string);
		if (!matcher.find()) {
			System.out.println(format_string);
			return;
		}

		int decimalPlaces = Integer.parseInt(matcher.group(1));

		double paramValue;
		try {
			paramValue = Double.parseDouble(param);
		} catch (NumberFormatException e) {
			System.out.println(format_string);
			return;
		}

		String replaceWith = String.format("%." + decimalPlaces + "f", paramValue);

		String[] parts = replaceWith.split("\\,");
		String firstPart = "";
		String secondPart = "";

		if (parts.length >= 1) {
			firstPart = parts[0];
		}
		if (parts.length >= 2) {
			secondPart = parts[1];
		}

		StringBuilder firstPartBuilder = new StringBuilder();
		for (char c : firstPart.toCharArray()) {
			if (replacements.containsKey(c)) {
				firstPartBuilder.append(replacements.get(c));
			} else {
				firstPartBuilder.append(c);
			}
		}
		firstPart = firstPartBuilder.toString();

		StringBuilder secondPartBuilder = new StringBuilder();
		for (char c : secondPart.toCharArray()) {
			int oldDigit = Character.getNumericValue(c);
			int newDigit = (oldDigit + 5) % 10;
			secondPartBuilder.append(newDigit);
		}
		secondPart = secondPartBuilder.toString();

		replaceWith = firstPart + (secondPart.isEmpty() ? "" : "." + secondPart);

		System.out.println(format_string.replace(matcher.group(0), replaceWith));

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
