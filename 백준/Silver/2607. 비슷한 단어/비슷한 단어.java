import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Error {
		int hashIdx, cnt;

		public Error(int hashIdx, int cnt) {
			this.hashIdx = hashIdx;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String word = br.readLine();
		int[] hash = new int[26];
		for (int i = 0; i < word.length(); i++) {
			hash[word.charAt(i) - 'A']++;
		}

		int[] nHash;
		int answer = 0;
		for (int i = 0; i < N - 1; i++) {
			String nWord = br.readLine();
			nHash = new int[26];

			for (int j = 0; j < nWord.length(); j++) {
				nHash[nWord.charAt(j) - 'A']++;
			}

			for (int j = 0; j < 26; j++) {
				nHash[j] -= hash[j];
			}

			int errorCnt = 0;
			int sum = 0;
			for (int j = 0; j < 26; j++) {
				errorCnt += Math.abs(nHash[j]);
				sum += nHash[j];
			}

			if (errorCnt == 0) {
				answer++;
			} else if (errorCnt == 1) {
				answer++;
			} else if (errorCnt == 2 && sum == 0) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}