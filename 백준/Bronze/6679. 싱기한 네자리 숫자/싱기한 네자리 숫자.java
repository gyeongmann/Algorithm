public class Main {
	public static void main(String[] args) {
	   StringBuilder sb = new StringBuilder();
	   for (int i = 1000; i < 10000; i++) {
	       String curr = String.valueOf(i);
	       int sum = 0;
	       for (int idx = 0; idx < 4; idx++) {
	           sum += curr.charAt(idx) - '0';
	       }
	       if (sum == baseTwelve(i) && sum == baseSixteen(i)) {
	           sb.append(i).append('\n');
	       }
	   }
	   System.out.print(sb.toString());
	}
	
	static int baseTwelve(int x) {
	    int res = 0;
	    for (int idx = 0; idx < 4; idx++) {
	        res += x % 12;
	        x /= 12;
	    }
	    return res;
	}
	
	static int baseSixteen(int x) {
	    int res = 0;
	    for (int idx = 0; idx < 4; idx++) {
	        res += x % 16;
	        x /= 16;
	    }
	    return res;
	}
}
