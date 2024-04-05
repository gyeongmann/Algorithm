import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. for문으로 1개의 포인터를 순회한다.
 * 2. 다른 포인터로 k번 만큼 순회하며, 중복을 제외한 숫자를 카운트 (포인터 순회 시에 나머지 연산)
 * 3. 먹은 초밥 중에 쿠폰에 해당하는게 없으면 정답 출력에 +1
 */
public class Main {
	/**
	 * @param N 접시의 수(2~30000)
	 * @param d 초밥의 가짓수(2~3000)
	 * @param k 연속해서 먹는 접시의 수(2~3000<=N)
	 * @param c 쿠폰 번호(1~d)
	 * @param belt 초밥 벨트
	 */
	static int N, d, k, c;
	static int[] belt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(in.readLine());
		} // 입력 끝
		
		int ans = 0;
		int pointer;
		for (int start = 0; start < N; start++) {
			int cnt = 0;
			int[] sushi = new int[d + 1];
			for (int i = start; i < start + k; i++) {
				pointer = i;
				if (pointer >= N) pointer %= N;
				sushi[belt[pointer]] = 1;
			}
			
			if (sushi[c] == 0) cnt++;
			for (int i = 1; i <= d; i++) {
				cnt += sushi[i];
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
