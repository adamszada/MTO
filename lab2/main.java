
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class lab2 {

	public static String swapCase(String s){
		char[] tmp = s.toCharArray();
		for(int i=0;i<tmp.length;i++){
			char c = tmp[i];
			if(Character.isUpperCase(c))
				tmp[i] = Character.toLowerCase(c);
			else if(Character.isLowerCase(c))
				tmp[i] = Character.toUpperCase(c);
		}
		return new String(tmp);
	}

	public static void my_printf(String format_string, String param){
		Pattern pattern = Pattern.compile("#(\\.\\d+)?k");
		Matcher matcher = pattern.matcher(format_string);
		if(!matcher.find()){
			System.out.println(format_string);
			return;
		}
		String tmp_str = format_string.substring(matcher.start(), matcher.end());
		int len = matcher.group(1) == null ? param.length() : Math.min(Integer.parseInt(matcher.group(1).substring(1)), param.length());
		param = swapCase(param);
		System.out.println(format_string.replace(tmp_str, param.substring(0, len)));
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
