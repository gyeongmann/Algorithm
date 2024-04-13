import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		String[] arr = new String[N + 1];
		for (int i = 1; i <= N; i++) {
			String pokemon = in.readLine();
			map.put(pokemon, i);
			arr[i] = pokemon;
		}
		
		for (int i = 0; i < M; i++) {
			String curr = in.readLine();
			if (Character.isDigit(curr.charAt(0))) { // 숫자면
				System.out.println(arr[Integer.parseInt(curr)]);
			} else {
				System.out.println(map.get(curr));
			}
		}
	}
}
