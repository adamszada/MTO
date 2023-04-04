
import java.io.*;
import java.util.regex.*;

class lab5 {
	
	public static String handleNumber(String num, int size){
		StringBuilder sb = new StringBuilder();
		if (num.charAt(0) == '-') {
			num = num.substring(1);
			sb.append('-');
			size -= 1;
		}
		int[] tmp = new int[num.length()];
		for (int j = 0; j < num.length(); j++) {
			tmp[j] = Character.getNumericValue(num.charAt(j)) - 1;
			if (tmp[j] == -1)
				tmp[j] = 9;
		}

		sb.insert(0," ".repeat(size));
		for (int digit : tmp)
			sb.append(digit);
		return sb.toString();
	}

	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#(\\d+)g");
		Matcher matcher = pattern.matcher(format_string);
		if(!matcher.find()){
			System.out.println(format_string);
			return;
		}
		String replacement = matcher.group(1);
		int tmpNumber = 0;
		try{
			tmpNumber = Integer.parseInt(replacement);
		} catch (NumberFormatException e) {
			System.out.println(format_string);
			return;
		}
		replacement = handleNumber(param, Math.max(0, tmpNumber - param.length()));
		System.out.println(format_string.replaceFirst(matcher.group(0), replacement));
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
