import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static class Pair {
		int r, c;
		char color;

		Pair(int r, int c, char color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		int cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		int cntRGB = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cntRGB++;
					bfsRGB(i, j);
				}
			}
		}
		System.out.println(cnt + " " + cntRGB);
	}

	private static void bfs(int i, int j) {
		Queue<Pair> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new Pair(i, j, map[i][j]));
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (map[nr][nc] == cur.color && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Pair(nr,nc,map[nr][nc]));
				}
			}
		}
	}
	private static void bfsRGB(int i, int j) {
		Queue<Pair> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new Pair(i, j, map[i][j]));
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			if (cur.color == 'B') {
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if (map[nr][nc] == cur.color && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Pair(nr,nc,map[nr][nc]));
					}
				}
			}
			else {
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if (map[nr][nc] != 'B' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Pair(nr,nc,map[nr][nc]));
					}
				}
			}
		}
	}
}
