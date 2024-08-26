import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int curr = 64;
		int cnt = 0;
		while (X > 0) {
			if (curr > X) {
				curr /= 2;
				continue;
			}
			X -= curr;
			cnt++;
		}

		System.out.println(cnt);
	}
}