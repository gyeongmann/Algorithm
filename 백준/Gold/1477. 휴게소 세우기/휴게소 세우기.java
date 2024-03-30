import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 1. 현재 주어지는 휴게소들 간의 거리를 구한다.
	 * 2. 0과 휴게소 사이 거리가 최대 값 사이에서 이분탐색을 시행한다.
	 * 3. 추가로 지으려는 휴게소 개수보다 작거나 같은 값을 후보에 추가한다.
	 * 4. 후보에서 최솟값을 출력한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 현재 휴게소의 개수
		int M = Integer.parseInt(st.nextToken()); // 더 지으려는 휴게소의 개수
		int L = Integer.parseInt(st.nextToken()); // 고속도로의 길이
		
		int[] pos = new int[N + 1]; // 현재 휴게소의 위치와 끝점(= 고속도로의 길이)
		int max = 0;
		if (N > 0) { // 휴게소가 있으면
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				pos[i] = Integer.parseInt(st.nextToken());
			}
			pos[N] = L;
			Arrays.sort(pos);
			
			// 휴게소 구간별 거리 구하기
			max = 0; // 거리의 최대값
			for (int i = N; i > 0; i--) {
				int curr = pos[i] -= pos[i - 1];
				if (curr > max) max = curr;
			}
		}
		else { // 휴게소가 없으면
			pos[0] = L;
			max = L;
		}
		
		// 이분 탐색
		int left = 1;
		int right = max;
		List<Integer> candidate = new ArrayList<>();
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			for (int i = 0; i <= N; i++) {
				int atLeast = pos[i] / mid; // 구간 내에 필요한 최소 휴게소 수
				if (pos[i] % mid == 0) atLeast--;
				sum += atLeast;
			}
			
			if (sum <= M) {
				candidate.add(mid);
				right = mid - 1;
				continue;
			}
			left = mid + 1;
		}
		
		System.out.println(Collections.min(candidate));
	}

}
