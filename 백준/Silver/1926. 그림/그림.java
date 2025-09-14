import java.io.*;
import java.util.*;

public class Main {
	static int N, M, size;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int maxSize = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
					maxSize = Math.max(maxSize, size);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxSize);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[i][j] = true;
		size = 0;
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			size++;
			int r = cur[0];
			int c = cur[1];
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
}
