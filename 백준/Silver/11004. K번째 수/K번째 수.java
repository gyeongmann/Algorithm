import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(0, N - 1);
		System.out.println(arr[K]);
	}

	private static void quickSort(int left, int right) {
		if (left >= right) return;

		int pivot = partition(left, right);

		if (pivot == K) {
			return;
		} else if (pivot > K) {
			quickSort(left, pivot - 1);
		} else {
			quickSort(pivot + 1, right);
		}
	}

	private static int partition(int left, int right) {
		int mid = (left + right) / 2;
		swap(left, mid);

		int pivot = arr[left];
		int i = left + 1;
		int j = right;

		while (i <= j) {
			while (i <= right && arr[i] < pivot) {
				i++;
			}
			while (j > left && arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		swap(left, j);
		return j;
	}

	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
