import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	/*
	 * 1. 승률이 99퍼 이상이면, 절대 변하지 않는다.
	 * 2. 최소 값을 구하는 문제
	 * 		-> 1판을 최소(left)
	 * 		-> 현재 게임 횟수를(right)
	 * 3. 이분 탐색으로 변화하는 값들의 최소를 구한다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long X = sc.nextInt(); // 게임 횟수
		long Y = sc.nextInt(); // 이긴 횟수
		long Z = Y * 100 / X; // 승률
		
		// 1.
		if (Z >= 99) {
			System.out.println(-1);
			return;
		}
		
		// 2.
		List<Long> ans = new ArrayList<>();
		long left = 1;
		long right = X;
		
		while (left <= right) {
			long mid = (left + right) / 2; // 시행 횟수
			long winRate = (Y + mid) * 100 / (X + mid);
			if (winRate > Z) { // 변화하면 ans에 추가, 값 줄여보기
				ans.add(mid);
				right = mid - 1;
				continue;
			}
			// 변화 안하면 left를 mid + 1로
			left = mid + 1;
		}
		System.out.println(Collections.min(ans));
		
	}
}
