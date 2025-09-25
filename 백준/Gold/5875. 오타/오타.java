import java.util.*;
import java.io.*;

public class Main {
    static int l;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        
        // '(' = +1, ')' = -1
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = (s.charAt(i-1) == '(' ? 1 : -1);
        }
        
        int[] pref = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i-1] + arr[i];
        }
        
        int total = pref[n];
        if (Math.abs(total) != 2 || n % 2 == 1) {
            System.out.println(0);
            return;
        }
        
        // 접두 최소
        int[] minPrefBefore = new int[n+1];
        minPrefBefore[0] = 0;
        for (int i = 1; i <= n; i++) {
            minPrefBefore[i] = Math.min(minPrefBefore[i-1], pref[i]);
        }
        
        // 접미 최소
        int[] minPrefFrom = new int[n+2];
        minPrefFrom[n+1] = Integer.MAX_VALUE;
        for (int i = n; i >= 1; i--) {
            minPrefFrom[i] = Math.min(pref[i], minPrefFrom[i+1]);
        }
        
        int ans = 0;
        if (total == -2) { // ')' -> '('
            for (int i = 1; i <= n; i++) {
                if (arr[i] == -1) {
                    if (minPrefBefore[i-1] >= 0 && minPrefFrom[i] >= -2) ans++;
                }
            }
        } else if (total == 2) { // '(' -> ')'
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 1) {
                    if (minPrefBefore[i-1] >= 0 && minPrefFrom[i] >= 2) ans++;
                }
            }
        }
        
        System.out.println(ans);
	}
}
