import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    if (a == 0) break;
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    
		    if(inValid(a, b, c)) {
		        sb.append("Invalid").append('\n');
		    } else if (a == b && b == c) {
		        sb.append("Equilateral").append('\n');
		    } else if (a == b || b == c || c == a) {
		        sb.append("Isosceles").append('\n');
		    } else {
		        sb.append("Scalene").append('\n');
		    }
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean inValid(int a, int b, int c) {
	    if (a + b <= c || a + c <= b || b + c <= a) return true;
	    return false;
	}
}
