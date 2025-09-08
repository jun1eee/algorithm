import java.util.*;
import java.io.*;

public class Solution {

	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static class Pair {
		int r;
		int c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = tmp;
					if (max < tmp) {
						max = tmp;
					}
				}
			}
			int cntMax = 0;
			for (int n = 0; n <= max; n++) {
				int cnt = 0;
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] <= n) {
							visited[i][j] = true;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j]) {
							cnt++;
							bfs(i,j);
						}
					}
				}
				cntMax = Math.max(cntMax, cnt);
			}
			sb.append("#").append(t).append(" ").append(cntMax).append('\n');
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int rr, int cc) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(rr, cc));
		visited[rr][cc] = true;

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Pair(nr, nc));
				}
			}
		}
	}
}
