import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * invalid
 * O의 개수가 더 많은 경우
 * X의 개수가 2개 이상 더 많은 경우
 * O가 한 줄을 이뤘을 때, X가 한 개 더 놓인 경우
 * X가 한 줄을 이뤘을 때, O가 같은 개수거나 그 이상인 경우
 */
public class Main {
	static final String END = "end";

	static int xCnt, oCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s;
		while (!(s = in.readLine()).equals(END)) {
			char[][] board = new char[3][3];
			xCnt = 0;
			oCnt = 0;
			for (int i = 0; i < 9; i++) {
				int row = i / 3;
				int col = i % 3;
				char ch = s.charAt(i);
				board[row][col] = ch;

				if (ch == 'X')
					xCnt++;
				else if (ch == 'O')
					oCnt++;
			}

			if (check(board)) {
				sb.append("valid").append('\n');
				continue;
			}
			sb.append("invalid").append('\n');
		}
		System.out.print(sb);
	}

	private static boolean check(char[][] board) {
		// 개수의 문제로 불가능한 경우
		if (xCnt > oCnt + 1 || xCnt < oCnt) {
			return false;
		}
		// -> 두 말의 개수 문제 만족
		// 둘 중 하나가 한 줄을 이룬 경우
		boolean xRow = false;
		boolean oRow = false;
		for (int row = 0; row < 3; row++) {
			if (rowCheck(board, row)) {
				if (board[row][0] == 'X') {
					xRow = true;
				} else if (board[row][0] == 'O') {
					oRow = true;
				}
			}
			
		}
		if (xRow && oRow) { // 둘 다 동시에 행이 빙고일 때
			return false;
		} else if (xRow && !oRow && xCnt == oCnt + 1) {
			return true;
		} else if (!xRow && oRow && xCnt == oCnt) {
			return true;
		}

		boolean xCol = false;
		boolean oCol = false;
		for (int col = 0; col < 3; col++) {
			if (colCheck(board, col)) {
				if (board[0][col] == 'X') {
					xCol = true;
				} else if (board[0][col] == 'O') {
					oCol = true;
				}
			}
		}
		if (xCol && oCol) { // 둘 다 동시에 행이 빙고일 때
			return false;
		} else if (xCol && !oCol && xCnt == oCnt + 1) {
			return true;
		} else if (!xCol && oCol && xCnt == oCnt) {
			return true;
		}

		if (diagCheck(board)) {
			if (board[1][1] == 'X') {
				if (xCnt == oCnt + 1) {
					return true;
				} else {
					return false;
				}
			} else if (board[1][1] == 'O') {
				if (xCnt == oCnt) {
					return true;
				} else {
					return false;
				}
			}
		}

		if (xCnt == 5 && oCnt == 4) {
			return true;
		}
		// 이외에는 게임을 추가 진행 가능
		return false;
	}

	private static boolean rowCheck(char[][] board, int row) {
		if (board[row][0] == '.') return false;
		if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
			return true;
		}
		return false;
	}

	private static boolean colCheck(char[][] board, int col) {
		if (board[0][col] == '.') return false;
		if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
			return true;
		}
		return false;
	}

	private static boolean diagCheck(char[][] board) {
		if (board[1][1] == '.') return false;
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}
		
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}
		return false;
	}
}
