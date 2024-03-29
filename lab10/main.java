
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class lab10 {
	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#a");
        Matcher matcher = pattern.matcher(format_string);

        if (!matcher.find()) {
            System.out.println(format_string);
            return;
        }

		int tmpNumber;
		try{
			tmpNumber = Integer.parseInt(param);
		} catch (NumberFormatException e) {
			System.out.println(format_string);
			return;
		}

		tmpNumber = (tmpNumber * 2) / String.valueOf(Math.abs(tmpNumber)).length();
		String replacement = tmpNumber%2==1 ? Integer.toHexString(tmpNumber) : String.valueOf(tmpNumber);

		System.out.println(matcher.replaceAll(replacement));
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
