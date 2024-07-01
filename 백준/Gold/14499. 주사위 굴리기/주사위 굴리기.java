import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, x, y;
	static int[][] map;
	static int[] dice;
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()); // N, M, x, y, K
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[6];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(st.nextToken());
			if (canMove(order)) {
				move(order);
			}
		}
	}
	
	private static boolean canMove(int order) {
		int nx = x + dx[order];
		int ny = y + dy[order];
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
			return false;
		}
		return true;
	}
	
	private static void move(int order) {
		// 이동
		x += dx[order];
		y += dy[order];
		
		if (order == 1) {
			int up = dice[0];
			int down = dice[1];
			int left = dice[2];
			int right = dice[3];
			
			dice[0] = left;
			dice[1] = right;
			dice[2] = down;
			dice[3] = up;
		}
		else if (order == 2) {
			int up = dice[0];
			int down = dice[1];
			int left = dice[2];
			int right = dice[3];
			
			dice[0] = right;
			dice[1] = left;
			dice[2] = up;
			dice[3] = down;
		}
		else if (order == 3) {
			int up = dice[0];
			int down = dice[1];
			int forward = dice[4];
			int back = dice[5];
			
			dice[0] = forward;
			dice[1] = back;
			dice[4] = down;
			dice[5] = up;
		}
		else if (order == 4) {
			int up = dice[0];
			int down = dice[1];
			int forward = dice[4];
			int back = dice[5];
			
			dice[0] = back;
			dice[1] = forward;
			dice[4] = up;
			dice[5] = down;
		}
		
		System.out.println(dice[0]);
		if (map[x][y] == 0) {
			map[x][y] = dice[1]; // 아랫면 복사
			return;
		}
		dice[1] = map[x][y]; // 맵을 아랫면에 복사
		map[x][y] = 0;
	}
	
	
}
