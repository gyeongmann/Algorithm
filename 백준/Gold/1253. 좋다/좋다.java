import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int cnt = 0;
		for (int target_idx = 0; target_idx < N; target_idx++) {
			int i = 0;
			int j = N-1;
			int target = arr[target_idx];

			while (i < j) {
				int curr = arr[i] + arr[j];
				if (curr == target) {
                    if (i != target_idx && j != target_idx){
                        cnt++;
                        break;
                    } else if (i == target_idx) {
                        i++;
                    } else if (j == target_idx) {
                        j--;
                    }
				} else if (curr < target) {
					i++;
				} else {
					j--;
				}
			}
		}

		System.out.println(cnt);
	}
}
