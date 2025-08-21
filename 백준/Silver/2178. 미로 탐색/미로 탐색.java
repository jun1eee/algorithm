import java.io.*;
import java.util.*;

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, M;
	static int[][] grid;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = str.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M];
		dist = new int[N][M];
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Pair> q = new ArrayDeque<>();		
		visited[0][0] = true;
		dist[0][0] = 1;
		
		q.offer(new Pair(0, 0));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			if (x == N - 1 && y == M - 1) {
				return dist[x][y];
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1) {
					visited[nx][ny] = true;
					dist[nx][ny] = dist[x][y] + 1;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		return -1;
	}

	
	static boolean inRange(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}



