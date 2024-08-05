import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int curr = 1;
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			list.add(list.size() - idx, curr++);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.println(sb);
	}
}