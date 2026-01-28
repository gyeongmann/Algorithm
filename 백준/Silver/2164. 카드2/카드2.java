import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(1);
			return;
		}

		int k = 0;
		while (N - ((int) Math.pow(2, k)) > 0) {
			k++;
		}

		k--;
		int m = N - ((int) Math.pow(2, k));
		System.out.println(2 * m);
	}
}
