import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, cnt;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			cnt = 0;
			queen(0);
			sb.append("#").append(t).append(" ").append(cnt).append('\n');
		}
		System.out.println(sb);
	}

	private static void queen(int row) {
		if (row == N) {
			cnt++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (isSafe(row, col)) {
				board[row][col] = 1;
				queen(row + 1);
				board[row][col] = 0;
			}
		}
	}

	private static boolean isSafe(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
}