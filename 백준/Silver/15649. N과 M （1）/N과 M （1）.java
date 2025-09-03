import java.io.*;
import java.util.*;


public class Main {
	public static int N,M;
	public static List<Integer> list;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		visited = new boolean[N+1];
		
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int i) {
		if (i == M) {
			for (int n : list) {
				sb.append(n).append(" ");
			}
			sb.append('\n');
			return;
		}
		
//		for (int j = 1; j <= N; j++) {
//			if (!visited[j]) {
//				visited[j] = true;
//				list.add(j);
//				dfs(i+1);
//				list.remove(list.size()-1);
//				visited[j] = false;
//			}
//		}
		for (int j = 1; j <= N; j++) {
			if (visited[j]) continue;
			visited[j] = true;
			list.add(j);
			dfs(i+1);
			list.remove(list.size()-1);
			visited[j] =false;
			
			
		}
	}
}



