import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/*
	1 3 6 6 7 9
	1 3 6 7 9
	 2 3 1 2
	   -
	[1,3] 2
	[6,9] 3

	3 6 7 8 10 12 14 15 18 20
	 3 1 1 2  2  2  1  3  2 -> 9개, 17
	 -     -  -        -
	[3,3] [6,8] [10,10] [12,15] [18,20]
	0 2 0 3 2
	[3,3] 0
	[6,8] 2
	[10, 12] 2
	[14, 15] 1
	[18, 20] 2
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (set.contains(a)) continue;
			set.add(a);
			pq.add(a);
		}

		int size = pq.size();
		PriorityQueue<Integer> gap = new PriorityQueue<>();
		for (int i = 0; i < size - 1; i++) {
			int curr = pq.poll();
			int nxt = pq.peek();
			gap.add(nxt - curr);
		}

		int ans = 0;
		for (int i = 0; i < size - K; i++) {
			if (gap.isEmpty()) break;
			ans += gap.poll();
		}
		System.out.println(ans);
	}
}