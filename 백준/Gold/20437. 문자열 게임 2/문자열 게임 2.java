import java.util.*;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int T = Integer.parseInt(sc.nextLine());
	    StringBuilder sb = new StringBuilder();
	    for (int tc = 0; tc < T; tc++) {
	        String word = sc.nextLine();
	        int K = Integer.parseInt(sc.nextLine());
	        int maxCnt = 0;
	        
	        Map<Character, List<Integer>> map = new HashMap<>();
	        int[] cnt = new int[26];
	        
	        int l = word.length();
	        for (int i = 0; i < l; i++) {
	            char ch = word.charAt(i);
                int idx = ch - 'a';
                cnt[idx]++;
                maxCnt = Math.max(maxCnt, cnt[idx]);
                
	            if (map.containsKey(ch)) {
	                map.get(ch).add(i);
	            } else {
	                map.put(ch, new ArrayList<>());
	                map.get(ch).add(i);
	            }
	        }
	        
	       // System.out.println(map);
	        if (maxCnt < K) {
	            sb.append(-1).append('\n');
	        } else {
	            int min = 987654321;
	            int max = 0;
	            for (int i = 0; i < 26; i++) {
	                if (cnt[i] >= K) {
	                    List<Integer> arr = map.get((char) (97+i));
	                    min = Math.min(min, getMin(arr, K));
	                    max = Math.max(max, getMax(arr, K));
	                }
	            }
	            sb.append(min + " " + max).append('\n');
	        }
	    }
	    
	    System.out.println(sb.toString());
	}
	
	static int getMax(List<Integer> arr, int K) {
	    Deque<Integer> dq = new ArrayDeque<>();
	    for (int i = 0; i < K; i++) {
	        dq.offer(arr.get(i));
	    }
	    int curr = Math.abs(dq.peekFirst() - dq.peekLast()) + 1;
	    int result = curr;
	    for (int i = K; i < arr.size(); i++) {
	        dq.pollFirst();
	        dq.offer(arr.get(i));
	        curr = Math.abs(dq.peekFirst() - dq.peekLast()) + 1;
	        result = Math.max(result, curr);
	    }
	    
	    return result;
	}
	
	static int getMin(List<Integer> arr, int K) {
	    Deque<Integer> dq = new ArrayDeque<>();
	    for (int i = 0; i < K; i++) {
	        dq.offer(arr.get(i));
	    }
	    int curr = Math.abs(dq.peekFirst() - dq.peekLast()) + 1;
	    int result = curr;
	    for (int i = K; i < arr.size(); i++) {
	        dq.pollFirst();
	        dq.offer(arr.get(i));
	        curr = Math.abs(dq.peekFirst() - dq.peekLast()) + 1;
	        result = Math.min(result, curr);
	    }
	    
	    return result;
	}
}