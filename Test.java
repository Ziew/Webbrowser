import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {
	public static void main(String[] args){
		try {
			StringBuffer b = new StringBuffer();
			URL myURL = new URL("http://wykop.pl/");
			Scanner scanner = new Scanner(myURL.openStream(), "utf-8");
			
			while(scanner.hasNextLine()){
				System.out.print(scanner.next());
				
			}
			System.out.println(b.toString());
			Convertion c = new Convertion();
			//c.convertToNode(b.toString());
		} 
		catch (MalformedURLException e) { 
			//new URL() failed
			// ...
		} 
		catch (IOException e) {   
			// openConnection() failed
			// ...
		}
	}
}
