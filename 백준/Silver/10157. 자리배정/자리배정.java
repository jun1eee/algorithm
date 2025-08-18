import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[][] arr = new int[M][N];

		int r = 0;
		int c = 0;
		int dir = 0;
		arr[r][c] = 1;
		for (int i = 2; i <= N * M; i++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nc < 0 || nr >= M || nc >= N || arr[nr][nc] != 0) {
				dir = (dir + 1) % 4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			arr[nr][nc] = i;
			r = nr;
			c = nc;
		}
		int num = Integer.parseInt(br.readLine());
		int row = 0;
		int col = 0;
		boolean check = false;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == num) {
					row = j;
					col = i;
					check = true;
					break;
				} 
			}
		}
		System.out.println(check ? (row + 1) + " " + (col + 1) : 0);
	}
}
