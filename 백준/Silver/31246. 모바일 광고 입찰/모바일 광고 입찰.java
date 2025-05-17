import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    if (a >= b) {
		        K--;
		        continue;
		    }
		    
		    if (map.containsKey(b-a)) {
		        int cnt = map.get(b-a);
		        map.put(b-a, cnt+1);
		    } else {
		        list.add(b-a);
		        map.put(b-a, 1);
		    }
		}
		
		if (K <= 0) {
		    System.out.println(0);
		    return;
		}
		
		Collections.sort(list);
		int ans = 1_000_000_000;
		int left = 0;
		int right = list.size()-1;
		while(left <= right) {
		    int mid = left + (right - left) / 2;
		    int cnt = count(map, list.get(mid));
		    if (K - cnt <= 0) {
		        ans = Math.min(ans, list.get(mid));
		        right = mid - 1;
		    } else {
		        left = mid + 1;
		    }
		}
		
	   // System.out.println(list);
	   // System.out.println(map);
	    System.out.println(ans);
	}
	
	static int count(Map<Integer, Integer> map, int mid) {
	    Set<Integer> set = map.keySet();
	    int cnt = 0;
	    for (int key : set) {
	        if (key <= mid) {
	            cnt += map.get(key);
	        }
	    }
	    return cnt;
	}
}
