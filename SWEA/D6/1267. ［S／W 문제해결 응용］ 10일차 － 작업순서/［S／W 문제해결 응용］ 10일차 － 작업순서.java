import java.io.*;
import java.util.*;

public class Solution {
	static int V, E;
	static ArrayList<Integer>[] edges;
	static int[] indegree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edges = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				edges[i] = new ArrayList<>();
			}
			indegree = new int[V + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges[a].add(b);
				indegree[b]++;
			}
			
			sb.append("#").append(t).append(" ");
			topologySort();
		}
		System.out.println(sb);
	}

	private static void topologySort() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int e : edges[cur]) {
				indegree[e]--;
				if(indegree[e] == 0) {
					q.add(e);
				}
			}
		}
		sb.append('\n');
	}
}