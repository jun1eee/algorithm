import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<Integer>[] list = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}
			boolean[] visited = new boolean[N+1];
			visited[1] = true;
			int cnt = 0;
			
			List<Integer> addFriend = new ArrayList<>();
			for (int l : list[1]) {
				if (!visited[l]) {
					visited[l] = true;
					cnt++;
					addFriend.add(l);
				}
			}
			
			for (int a : addFriend) {
				for (int b : list[a]) {
					if(!visited[b]) {
						visited[b] = true;
						cnt++;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(cnt).append('\n');
		}
		System.out.println(sb.toString());
	}
}
