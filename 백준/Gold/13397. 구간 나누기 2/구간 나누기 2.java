import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[] arr;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
		    int curr = Integer.parseInt(st.nextToken());
		    right = Math.max(right, curr);
		    arr[i] = curr;
		}
		
		int answer = 10_001;
		
		while (left <= right) {
		    int mid = left + (right - left)/2;
		    if (check(mid)) {
		        right = mid-1;
		        answer = Math.min(answer, mid);
		    } else {
		        left = mid+1;
		    }
		}
		
		System.out.println(answer);
	}
	
	static boolean check(int mid) {
	    int cnt = 1;
	    
	    int min = arr[0];
	    int max = arr[0];
	    for (int i = 1; i < N; i++) {
	        min = Math.min(min, arr[i]);
	        max = Math.max(max, arr[i]);
	        
	        if (max - min > mid) {
	            cnt++;
	            min = arr[i];
	            max = arr[i];
	        }
	        
	        if (cnt > M) return false;
	    }
	    
	    return true;
	}
}
