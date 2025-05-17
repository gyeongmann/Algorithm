import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> diffCount = new HashMap<>();
	    int guaranteed = 0;
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    
		    if (a >= b) {
		        guaranteed++;
		        continue;
		    }
		    
		    int diff = b - a;
	        diffCount.put(diff, diffCount.getOrDefault(diff, 0) + 1);
		}
		
		if (guaranteed >= K) {
	        System.out.println(0);
	        return;
	    }
		
		List<Integer> keys = new ArrayList<>(diffCount.keySet());
	    Collections.sort(keys);
	    
	    int[] prefixSum = new int[keys.size()];
	    prefixSum[0] = diffCount.get(keys.get(0));
	    for (int i = 1; i < keys.size(); i++) {
	        prefixSum[i] = prefixSum[i - 1] + diffCount.get(keys.get(i));
	    }
	    
		int ans = 1_000_000_000;
		int left = 0;
		int right = keys.size()-1;
		int need = K - guaranteed;
		while(left <= right) {
		    int mid = left + (right - left) / 2;
		    int cnt = prefixSum[mid];
		    if (cnt >= need) {
		        ans = keys.get(mid);
	            right = mid - 1;
		    } else {
		        left = mid + 1;
		    }
		}
		
	    System.out.println(ans);
	}
}
