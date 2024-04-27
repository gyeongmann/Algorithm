import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(in.readLine());
		int powK = (int) Math.pow(2, K);
		arr = new int[powK];
		tree = new int[powK];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i < powK; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		BinarySearch(1, powK - 1, 1); // l, r, idx
		
//		System.out.println(Arrays.toString(tree));
		
		int idx = 1;
		for (int depth = 0; depth < K; depth++) {
			int length = (int) Math.pow(2, depth);
			for (int i = 0; i < length; i++) {
				System.out.print(tree[idx++] + " ");
			}
			System.out.println(); // 줄바꿈
		}
	}

	private static void BinarySearch(int l, int r, int idx) {
		if (l == r) {
			tree[idx] = arr[l];
			return;
		}
		
		int m = (l + r) / 2;
		tree[idx] = arr[m];
		BinarySearch(l, m - 1, idx * 2);
		BinarySearch(m + 1, r, idx * 2 + 1);
	}
}
