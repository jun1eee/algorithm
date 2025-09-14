import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				max = Math.max(max, tmp);
			}
		}
		int cntMax = 0;
		for (int height = 0; height <= max; height++) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= height) {
						visited[i][j] = true;
					}
				}
			}
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			cntMax = Math.max(cntMax, cnt);
		}
		System.out.println(cntMax);
	}

	private static void bfs(int i, int j) {
		Queue<Pair> q = new ArrayDeque<>();
		visited[i][j] = true;
		q.offer(new Pair(i, j));

		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			for (int index = 0; index < 4; index++) {
				int nr = r + dr[index];
				int nc = c + dc[index];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Pair(nr,nc));
				}
			}
		}
	}
}
