import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		visited = new boolean[N][M];
		bfs();

		System.out.println(map[N - 1][M - 1]);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			if (r == N - 1 && c == M - 1)
				return;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (map[nr][nc] == 0 || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				map[nr][nc] = map[r][c] + 1;
				q.offer(new int[] { nr, nc });
			}
		}
	}
}
