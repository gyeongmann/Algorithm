import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int line = 1;
	    while(true) {
	        String s = br.readLine();
	        if (s.startsWith("-")) break;
	        
	        int l = s.length();
	        int open = 0;
	        int answer = 0;
	        for (int i = 0; i < l; i++) {
	            char ch = s.charAt(i);
	            if (ch == '{') {
	                open++;
	            } else if (open == 0){
	                answer++;
	                open++;
	            } else {
	                open--;
	            }
	        }
	        
	        answer += open/2;
	        System.out.println(line++ + ". " + answer);
	    }
	}
}
