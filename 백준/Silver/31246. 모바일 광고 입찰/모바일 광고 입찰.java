import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int mol[] = new int[N];
		int other[] = new int[N];
		
		int now = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    mol[i] = Integer.parseInt(st.nextToken());
		    other[i] = Integer.parseInt(st.nextToken());
		    
		    if (mol[i] >= other[i]) {
		        now++;
		        continue;
		    }
		    
		    max = Math.max(max, other[i] - mol[i]);
		}
		
		if (now >= K) {
		    System.out.println(0);
		    return;
		}
		
		int left = 0;
		int right = max;
		int ans = 0;
		while(left <= right) {
		    int mid = (left + right) / 2;
		    int cnt = 0;
		    for (int i = 0; i < N; i++) {
		        if (mol[i] + mid >= other[i]) {
		            cnt++;
		        }
		    }
		    
		    if (cnt >= K) {
		        right = mid - 1;
		        ans = mid;
		    } else {
		        left = mid + 1;
		    }
		}
		
		System.out.println(ans);
	}
}
