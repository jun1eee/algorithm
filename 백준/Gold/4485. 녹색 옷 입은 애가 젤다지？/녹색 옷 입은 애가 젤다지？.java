import java.io.*;
import java.util.*;

public class Main {
	public static class Node implements Comparable<Node> {
		int i, j, weight;

		Node(int i, int j, int weight) {
			this.i = i;
			this.j = j;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	private static final int INF = 100_000_000;
	private static int N;
	private static int[][] map;
	private static int[][] dist;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], INF);
			}
			dijkstra();
			sb.append("Problem").append(" ").append(cnt++).append(": ").append(dist[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		dist[0][0] = map[0][0];
		pq.offer(new Node(0, 0, dist[0][0]));
		
		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curI = curNode.i;
			int curJ = curNode.j;
			if (visited[curI][curJ] == true)
				continue;
			visited[curI][curJ] = true;
			for (int i = 0; i < 4; i++) {
				int nextI = curI + dr[i];
				int nextJ = curJ + dc[i];
				if (nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= N) continue;
				if (visited[nextI][nextJ]) continue;
				if (dist[nextI][nextJ] > dist[curI][curJ] + map[nextI][nextJ]) {
					dist[nextI][nextJ] = dist[curI][curJ] + map[nextI][nextJ];
					pq.add(new Node(nextI, nextJ, dist[nextI][nextJ]));
				}
			}
		}
	}
}