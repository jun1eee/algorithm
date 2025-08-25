import java.io.*;
import java.util.*;

public class Main {

	static int M, N;
	static int[][] arr;
//	static int[][] dist;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Pair> q = new ArrayDeque<>();

	public static class Pair {
		int x, y, cnt;

		Pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][j] = tmp;
				if (tmp == 1) {
					q.offer(new Pair(i, j, 0));
				}
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		int cnt = 0;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x, y = cur.y;
			cnt = cur.cnt;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					q.offer(new Pair(nx, ny, cnt + 1));
				}
			}
		}
		
		boolean check = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					check = false;
					break;
				}
			}
		}
		if (check) {
			return cnt;
		} else return -1;		
	}
}
