
import java.io.*;
import java.util.regex.*;

class lab3 {
	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#([1-9]\\d*)?(\\.\\d+)?k");
		Matcher matcher = pattern.matcher(format_string);
		if(!matcher.find()){
			System.out.println(format_string);
			return;
		}
		String replace = matcher.group();
		if(matcher.group(1)!=null)
			System.out.println(matcher.group(1));
		if(matcher.group(2)!=null)
			System.out.println(matcher.group(2));
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