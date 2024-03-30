import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, K, ans;
	static int[] cost = new int[100001];
	static boolean[] vis = new boolean[100001];
	
	static class Pair implements Comparable<Pair> {
		int idx, time;

		public Pair(int idx, int time) {
			this.idx = idx; // 현재 위치
			this.time = time; // 걸린 시간
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(this.time, o.time);
		}

		@Override
		public String toString() {
			return "Pair [idx=" + idx + ", time=" + time + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		if (N >= K) {
			System.out.println(N - K);
			return;
		}
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		BFS();
		
		System.out.println(cost[N]);
	}

	private static void BFS() {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.add(new Pair(K, 0));
		
		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int idx = pair.idx;
			int time = pair.time;
			vis[idx] = true;
			
			if (idx % 2 == 0 && isValid(idx / 2)) {
				if (cost[idx / 2] > time) {
					cost[idx / 2] = time;
					q.add(new Pair(idx / 2, time));
				}
			}
			if (isValid(idx + 1)) {
				if (cost[idx + 1] > time + 1) {
					cost[idx + 1] = time + 1;
					q.add(new Pair(idx + 1, time + 1));
				}
			}
			if (isValid(idx - 1)) {
				if (cost[idx - 1] > time + 1) {
					cost[idx - 1] = time + 1;
					q.add(new Pair(idx - 1, time + 1));
				}
			}
		}
	}

	private static boolean isValid(int i) {
		if (i < 0 || i > 100000) return false;
		if (vis[i]) return false;
		return true;
	}
}