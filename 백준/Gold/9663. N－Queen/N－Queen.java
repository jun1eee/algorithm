import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		queen(0);

		System.out.println(cnt);
	}

	public static void queen(int row) {
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

	public static boolean isSafe(int row, int col) {
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
