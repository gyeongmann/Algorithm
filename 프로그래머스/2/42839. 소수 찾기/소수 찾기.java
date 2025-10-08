import java.util.*;

class Solution {
    int l;
    String[] nums;
    Set<Integer> primeSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        l = numbers.length();
        nums = numbers.split("");
        
        for (int depth = 1; depth <= l; depth++) {
            comb(depth, 0, new String[depth], new boolean[l]);
        }
        
        answer = primeSet.size();
        return answer;
    }
    
    void comb(int depth, int sidx, String[] sel, boolean[] vis) {
        if (sidx == depth) {
            String s = "";
            for (int i = 0; i < depth; i++) {
                s += sel[i];
            }
            int n = Integer.parseInt(s);
            if (isPrime(n)) {
                primeSet.add(n);
            }
            return;
        }
        
        for (int i = 0; i < l; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            sel[sidx] = nums[i];
            comb(depth, sidx+1, sel, vis);
            vis[i] = false;
        }
    }
    
    boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        int sqrt = (int) Math.sqrt(n);
        sqrt++;
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}