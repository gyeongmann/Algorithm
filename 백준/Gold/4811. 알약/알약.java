import java.util.*;

public class Main {
    static long[][] dp = new long[31][31];
    
	public static void main(String[] args) {
	    for (int i = 0; i <= 30; i++) {
	        Arrays.fill(dp[i], -1);
	    }
	    
	    dp[0][0] = 1;
	    dp[0][1] = 1;
	    for (int i = 1; i <= 30; i++) {
	        dfs(i, 0);
	    }
	    
	    Scanner sc = new Scanner(System.in);
	    StringBuilder sb = new StringBuilder();
	    
	    while (true) {
	        int i = Integer.parseInt(sc.nextLine());
	        if (i == 0) {
	            System.out.println(sb.toString());
	            return;
	        }
	        sb.append(dp[i][0]).append('\n');
	    }
	}
	
	static long dfs(int w, int h) {
	    if (dp[w][h] != -1) {
	        return dp[w][h];
	    }
	    
	    long result = 0;
	    if (w > 0) result += dfs(w-1, h+1);
	    if (h > 0) result += dfs(w, h-1);
	    
	    return dp[w][h] = result;
	}
}