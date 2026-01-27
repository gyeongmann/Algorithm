import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String word = br.readLine();

		st = new StringTokenizer(br.readLine());
		int[] target = new int[4];
		for (int i = 0; i < 4; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		int[] curr = {0, 0, 0, 0};
		int left = 0;
		int right = left + P - 1;

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		for (int i = left; i <= right; i++) {
			char ch = word.charAt(i);
			curr[map.get(ch)]++;
		}
		
		int cnt = 0;
		while (right < S) {
			if (isAvaliable(target, curr)) {
				cnt++;
			}
			
			right++;
			if (right >= S) break;
			char ch = word.charAt(right);
			curr[map.get(ch)]++;
			ch = word.charAt(left);
			curr[map.get(ch)]--;
			left++;
		}

		System.out.println(cnt);
	}

	private static boolean isAvaliable(int[] target, int[] curr) {
		for (int i = 0; i < 4; i++) {
			if (target[i] > curr[i]) {
				return false;
			}
		}
		return true;
	}
}
