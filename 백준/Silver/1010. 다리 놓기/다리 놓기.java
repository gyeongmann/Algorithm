import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] pascalTriangle = new int[31][31];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		pascalTriangle[0][0] = 1;
		int col = 1;
		for (int r = 0; r < 30; r++) {
			for (int c = 0; c < col; c++) {
				pascalTriangle[r + 1][c] += pascalTriangle[r][c];
				pascalTriangle[r + 1][c + 1] += pascalTriangle[r][c];
			}
			col++;
		}
		
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(pascalTriangle[M][N]);
		}
	}
}