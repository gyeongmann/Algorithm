import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 보석 종류

		int left = 1;
		int right = 0;
		
		// 보석의 개수, 동일한 개수의 보석 수
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < M; i++) {
			int jewel = Integer.parseInt(in.readLine());
			if (jewel > right)
				right = jewel;

			if (map.containsKey(jewel)) {
				int cnt = map.get(jewel);
				map.put(jewel, cnt + 1);
				continue;
			}
			map.put(jewel, 1);
		}
		
		// 이분 탐색
		PriorityQueue<Integer> ans = new PriorityQueue<>();
		while (left <= right) { // while로 left가 right보다 작은 동안 반복
			int mid = (left + right) / 2;
			
			// 1. mid 값이 각 보석의 최적 인원 구하기
			int candidate = 0;
			for (int key : map.keySet()) {
				int quotient = key / mid;
				if (key % mid > 0) quotient++;
				candidate += map.get(key) * quotient;
			}
			
			// 2. 전체 인원보다 작거나 같으면 ans 추가, mid 갱신
			if (candidate <= N) {
				ans.add(mid);
				right = mid - 1;
				continue;
			}
			left = mid + 1;
		}
		
		System.out.println(ans.peek());
	}
}
