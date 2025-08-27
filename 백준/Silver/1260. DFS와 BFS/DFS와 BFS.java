import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] g;
	static boolean visited1[];
	static boolean visited2[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		g = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			g[n1].add(n2);
			g[n2].add(n1);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(g[i]);
		}
		
		visited1 = new boolean[N+1];
		visited2 = new boolean[N+1];
		sb.append(V).append(" ");
		dfs(V);
		sb.append('\n');
		bfs(V);
		System.out.println(sb);
	}
	
	static void dfs(int V) {
		visited1[V] = true;
		for (int v : g[V]) {
			if (!visited1[v]) {
				visited1[v] = true;
				sb.append(v).append(" ");
				dfs(v);
			}
		}
	}
	
	static void bfs(int V) {
		visited2[V] = true;
		sb.append(V).append(" ");
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : g[cur]) {
				if(!visited2[next]) {
					visited2[next] = true;
					sb.append(next).append(" ");
					q.add(next);
				}
			}
		}
		sb.append('\n');
	}
}
