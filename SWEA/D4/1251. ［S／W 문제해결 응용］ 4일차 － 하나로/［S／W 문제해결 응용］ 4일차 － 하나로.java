import java.io.*;
import java.util.*;

public class Solution {
	static class Edge implements Comparable<Edge> {
		int from, to;
		long cost;

		public Edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	private static final int INF = Integer.MAX_VALUE;
	private static int N;
	private static double E;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] x = new int[N];
			int[] y = new int[N];

			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(stX.nextToken());
				y[i] = Integer.parseInt(stY.nextToken());
			}
			E = Double.parseDouble(br.readLine());

			boolean[] visited = new boolean[N];
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			visited[0] = true;
			int picked = 1;
			long total = 0;
			
			for (int i = 0; i < N; i++) {
				long dx = x[0] - x[i];
				long dy = y[0] - y[i];
				pq.offer(new Edge(0, i, dx * dx + dy * dy));
			}
			// Prim: 매번 가장 싼 간선으로 새로운 정점을 하나씩 연결
			while (picked < N && !pq.isEmpty()) {
				Edge e = pq.poll();
				if (visited[e.to])
					continue; // 이미 MST에 있으면 스킵

				// 새 정점 채택
				visited[e.to] = true;
				total += e.cost;
				picked++;

				// 새로 포함된 정점에서 뻗는 간선을 PQ에 추가
				for (int v = 0; v < N; v++) {
					if (!visited[v]) {
						long dx = x[e.to] - x[v];
						long dy = y[e.to] - y[v];
						pq.offer(new Edge(e.to, v, dx * dx + dy * dy));
					}
				}
			}

			long answer = Math.round(total * E);
			sb.append('#').append(t).append(' ').append(answer).append('\n');
		}

		System.out.print(sb.toString());
	}
}