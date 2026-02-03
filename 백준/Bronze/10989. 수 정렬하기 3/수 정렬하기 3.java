import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int maxDigitCount = 0;
		for (int i = 0; i < N; i++) {
			String num = br.readLine();
			A[i] = Integer.parseInt(num);
			maxDigitCount = Math.max(maxDigitCount, num.length());
		}

		br.close();
		radixSort(A, maxDigitCount);
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void radixSort(int[] arr, int maxDigitCount) {
		int[] output = new int[arr.length];
		int digitCount = 1;
		int count = 0;
		while (count != maxDigitCount) {
			int[] bucket = new int[10];
			for (int i = 0; i < arr.length; i++) {
				bucket[(arr[i] / digitCount) % 10]++;
			}
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = arr.length - 1; i >= 0; i--) {
				output[bucket[((arr[i] / digitCount) % 10)] - 1] = arr[i];
				bucket[(arr[i] / digitCount) % 10]--;
			}
			for (int i = 0; i < arr.length; i++) {
				arr[i] = output[i];
			}
			digitCount = digitCount * 10;
			count++;
		}
	}
}
