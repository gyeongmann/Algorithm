import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int s = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine());
		int x = -1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    String method = st.nextToken();
		    
		    switch(method) {
		        case "add":
		            x = Integer.parseInt(st.nextToken());
		            s = add(s, x);
		            break;
	            case "remove":
		            x = Integer.parseInt(st.nextToken());
		            s = remove(s, x);
		            break;
	            case "check":
		            x = Integer.parseInt(st.nextToken());
		            sb.append(check(s, x)).append('\n');
		            break;
	            case "toggle":
		            x = Integer.parseInt(st.nextToken());
		            s = toggle(s, x);
		            break;
	            case "all":
		            s = all();
		            break;
	            case "empty":
		            s = empty();
		            break;
		    }
		}
		
		System.out.println(sb.toString());
	}
	
	private static int add(int s, int x) {
	    x = 1 << (x-1);
	    s |= x;
	    return s;
	}
	
	private static int remove(int s, int x) {
	    x = 1 << (x-1);
	    if ((x & s) != 0) {
	        s -= x;
	    }
	    return s;
	}
	
	private static int check(int s, int x) {
	    x = 1 << (x-1);
	    if ((x & s) != 0) {
	        return 1;
	    }
	    return 0;
	}
	
	private static int toggle(int s, int x) {
	    x = 1 << (x-1);
	    return s ^ x;
	}
	
	private static int all() {
	    return 1_048_575;
	}
	
	private static int empty() {
	    return 0;
	}
}
