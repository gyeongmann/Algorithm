import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	/*
	1 i x : i번째 기차에 x번째 좌석에 사람을 태워라. 이미 있으면 continue
	2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차, 아무도 없으면 continue
	3 i : i번째 기차에 앉아있는 승객들이 모두 한 칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다.
			만약 20번째 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
	4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로 간다. k번째 앉은 사람은 k-1번째 자리로 이동하여 앉는다.
			만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine()); // N, M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] trains = new int[N + 1];

		int clear = (1 << 20) - 1; // 20번째 넘어가면 clear
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken()); // 명령 종류
			int idx = Integer.parseInt(st.nextToken());
			if (op == 1) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				int person = 1 << x;
				trains[idx] |= person;
			} else if (op == 2) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				int person = 1 << x;
				trains[idx] &= ~person;
			} else if (op == 3){
				trains[idx] <<= 1;
				trains[idx] &= clear; // 20번째 넘어가면 0으로 처리
			} else if (op == 4){
				trains[idx] >>= 1;
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(trains[i]);
		}
		System.out.println(set.size());
	}
}