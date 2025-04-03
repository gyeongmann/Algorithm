import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int sum = 0;
	    for (int i = 0; i < 5; i++) {
	        int curr = Integer.parseInt(st.nextToken());
	        sum += curr * curr;
	    }
	    sum %= 10;
	    System.out.println(sum);
	}
}
