import java.util.*;

public class Main {
    
    static int[] square = new int[224];
    static int min = 5;
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int n = Integer.parseInt(sc.nextLine());
	    
	    for (int i = 1; i <= 223; i++) {
	        square[i] = i*i;
	    }
	    
	    int root = (int) Math.sqrt(n);
	    
	    dfs(n, 1);
	    System.out.println(min);
	}
	
	static void dfs(int remain, int depth) {
	    if (depth >= min || remain < 0 || depth > 4) {
	        return;
	    }
	    
	    int root = (int) Math.sqrt(remain);
	    
	    for (int curr = root; curr >= 1; curr--) {
	        int next = remain-square[curr];
	        if (next == 0) {
	            min = Math.min(min, depth);
	            return;
	        }
	        dfs(next, depth+1);
	    }
	}
}