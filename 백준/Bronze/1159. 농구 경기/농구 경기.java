import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    int[] cnt = new int[26];
	    for (int i = 0; i < N; i++) {
	        char ch = br.readLine().charAt(0);
	        int idx = ch - 'a';
	        cnt[idx]++;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < 26; i++) {
	        if (cnt[i] >= 5) {
	            char ch = (char) (97 + i);
	            sb.append(ch);
	        }
	    }
	    
	    if (sb.toString().length() == 0) {
	        System.out.println("PREDAJA");
	    } else {
	        System.out.println(sb.toString());
	    }
	}
}