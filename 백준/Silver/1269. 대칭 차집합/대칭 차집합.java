import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		st = new StringTokenizer(sc.nextLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(sc.nextLine());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(st.nextToken());
		}
		
		st = new StringTokenizer(sc.nextLine());
		int cnt = N+M;
		for (int i = 0; i < M; i++) {
            String curr = st.nextToken();
			if (set.contains(curr)) {
				cnt -= 2;
			}
		}

		System.out.println(cnt);
	}
}