
import java.io.*;
import java.util.regex.*;

class lab6 {
	public static void my_printf(String format_string, String param){
        Pattern pattern = Pattern.compile("#\\.(\\d+)g");
        Matcher matcher = pattern.matcher(format_string);

        if (!matcher.find()) {
            System.out.println(format_string);
            return;
        }

        String replacement = matcher.group(1);
        int tmpNumber  = 0;

        try {
            tmpNumber  = Integer.parseInt(replacement );
        } catch (NumberFormatException e) {
            System.out.println(format_string);
            return;
        }

        int val = 0;

        try {
            val = Integer.parseInt(param);
        } catch (NumberFormatException e) {
            System.out.println(format_string);
            return;
        }

        replacement = String.format("%0" + tmpNumber  + "d", Math.abs(val))
            .chars()
            .map(Character::getNumericValue)
            .map(c -> (c * 9 + 1) % 10)
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();

        if (val < 0)
            replacement = "-" + replacement;

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
