import java.io.*;
import java.util.*;

public class Main {

	static int n, m, targetR, targetC;
	static int[][] map;
	static int[][] dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];

		targetR = -1;
		targetC = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				dist[i][j] = -1;
				if (tmp == 2) {
					targetR = i;
					targetC = j;
				}
				if (tmp == 0) {
					dist[i][j] = 0;
				}
			}
		}
		bfs();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Pair> q = new ArrayDeque<>();
		dist[targetR][targetC] = 0;
		q.offer(new Pair(targetR, targetC));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 0)
					continue;
				if (map[nr][nc] == 1 && dist[nr][nc] == -1) {
					dist[nr][nc] = dist[r][c] + 1;
					q.offer(new Pair(nr,nc));
				}
			}
		}

	}
}
