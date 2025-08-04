import java.util.*;

public class Main {
    static long mod = 1_000_000_007L;
    static Map<Long, Long> memo = new HashMap<>();
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		System.out.println(f(n));
	}
	
	static long f(long idx) {
	    if (idx == 0) return 0;
	    if (idx == 1) return 1;
	    
	    if (memo.containsKey(idx)) return memo.get(idx);
	    
	    long res;
	    if (idx % 2 == 0) {
	        long n = idx/2;
	        long f_n = f(n);
	        long f_n1 = f(n-1);
	        long tmp = (2 * f_n1 % mod + f_n) % mod;
	        res = (f_n*tmp) % mod;
	    } else {
    	    long n = (idx-1)/2;
            long f_n = f(n) % mod;
            long f_n1 = f(n+1) % mod;
    	    res = (f_n1*f_n1 + f_n*f_n) % mod;
	    }
	    
	    memo.put(idx, res);
	    return res;
	}
}
