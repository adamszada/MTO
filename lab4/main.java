
import java.io.*;
import java.util.regex.*;

class lab4 {

	public static String handleNumber(int number){
		boolean isNegative = number<0;
		number = Math.abs(number);
		int reverse = 0;
		while(number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number/10;
		}
		if(isNegative)
			reverse*=-1;
		return Integer.toString(reverse);
	}

	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#g");
		Matcher matcher = pattern.matcher(format_string);
		if(!matcher.find()){
			System.out.println(format_string);
			return;
		}
		String replacement = matcher.group();
		int tmpNumber = 0;
		try{
			tmpNumber = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			System.out.println(format_string);
			return;
		}
		param = handleNumber(tmpNumber);
		System.out.println(format_string.replaceAll(replacement, param));
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
