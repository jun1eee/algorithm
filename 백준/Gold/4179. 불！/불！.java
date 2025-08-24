import java.io.*;
import java.util.*;

public class Main {

	static int R, C;
	static char[][] map;
	static int[][] distF, distJ;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Pair> jihunQ = new ArrayDeque<>();
	static Queue<Pair> fireQ = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		distF = new int[R][C];
		distJ = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char tmp = str.charAt(j);
				map[i][j] = tmp;
				distF[i][j] = -1;
				distJ[i][j] = -1;
				if (tmp == 'J') {
					jihunQ.offer(new Pair(i, j));
					distJ[i][j] = 0;
				} else if (tmp == 'F') {
					fireQ.offer(new Pair(i, j));
					distF[i][j] = 0;
				}
			}
		}

		fireBFS();
		int answer = jihunBFS();
		System.out.println( answer == -1 ? "IMPOSSIBLE" : answer);
	}

	public static void fireBFS() {
		while (!fireQ.isEmpty()) {
			Pair cur = fireQ.poll();
			int x = cur.x;
			int y = cur.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				if (distF[nx][ny] >= 0 || map[nx][ny] == '#')
					continue;

				distF[nx][ny] = distF[x][y] + 1;
				fireQ.offer(new Pair(nx, ny));
			}

		}
	}

	public static int jihunBFS() {

		while (!jihunQ.isEmpty()) {
			Pair cur = jihunQ.poll();
			int x = cur.x;
			int y = cur.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					return distJ[x][y] + 1;
				}

				if (distJ[nx][ny] >= 0 || map[nx][ny] == '#')
					continue;

				if (distF[nx][ny] != -1 && (distF[nx][ny] <= distJ[x][y] + 1))
					continue;

				distJ[nx][ny] = distJ[x][y] + 1;
				jihunQ.offer(new Pair(nx, ny));
			}
		}
		return -1;
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
