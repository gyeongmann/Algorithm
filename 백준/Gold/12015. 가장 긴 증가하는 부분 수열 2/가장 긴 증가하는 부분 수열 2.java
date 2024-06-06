import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		List<Integer> lis = new ArrayList<>();
		lis.add(0);
		StringTokenizer st = new StringTokenizer(in.readLine()); // 숫자들
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(st.nextToken());
			int size = lis.size();
			
			if (lis.get(size - 1) < curr) {
				lis.add(curr);
				continue;
			}
			
			int idx = binarySearch(lis, curr);
			if (lis.get(idx) == curr) {
				lis.set(idx, curr);
				continue;
			}
			lis.set(idx + 1, curr);
		}
		
		System.out.println(lis.size() - 1);
	}
	
	private static int binarySearch(List<Integer> lis, int key) {
		int idx = 0;
		int left = 0;
		int right = lis.size();
		int mid = (left + right) / 2;
		
		while (left <= right) {
			if (lis.get(mid) < key) {
				left = mid + 1;
			} else if (lis.get(mid) > key) {
				right = mid - 1;
			} else {
				return mid;
			}
			
			mid = (left + right) / 2;
		}
		
		return mid;
	}
}
