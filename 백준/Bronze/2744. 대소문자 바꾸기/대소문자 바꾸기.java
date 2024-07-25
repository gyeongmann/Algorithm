import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
		    char ch = s.charAt(i);
		    if (Character.isUpperCase(ch)) {
		        sb.append(Character.toLowerCase(ch));
		        continue;
		    }
		    sb.append(Character.toUpperCase(ch));
		}
		System.out.println(sb.toString());
	}
}