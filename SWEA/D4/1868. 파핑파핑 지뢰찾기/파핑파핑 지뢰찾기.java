import java.util.*;
import java.io.*;

public class Solution {

	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	private static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static class Pair {
		int r;
		int c;

		Pair(int x, int y) {
			this.r = x;
			this.c = y;
		}
	}

	public static int bomb(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == '*')
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bomb(i, j) == 0 && map[i][j] != '*' && !visited[i][j]) {
						answer++;
						bfs(i, j);
					}

				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						answer++;
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void bfs(int i, int j) {
		Queue<Pair> q = new ArrayDeque<>();
		map[i][j] = '0';
		visited[i][j] = true;
		q.offer(new Pair(i, j));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for (int k = 0; k < 8; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (bomb(nr, nc) == 0 && !visited[nr][nc]) {
					map[nr][nc] = '0';
					visited[nr][nc] = true;
					q.offer(new Pair(nr, nc));
				} else {
					map[nr][nc] = '1';
				}
			}
		}
	}
}