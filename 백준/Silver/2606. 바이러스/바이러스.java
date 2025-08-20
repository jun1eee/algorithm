import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] g;
	public static boolean[] visited;
	public static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] u = new int[M];
		int[] v = new int[M];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			u[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		g = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			g[u[i]].add(v[i]);
			g[v[i]].add(u[i]);
		}
		
		visited = new boolean[N+1]; 
		visited[1] = true;
		dfs(1);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int n) {
		for (int num : g[n]) {
			if(!visited[num]) {
				visited[num] = true;
				cnt++;
				dfs(num);
			}
		}
	}
}
