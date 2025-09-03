import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static List<Integer> list;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		visited = new boolean[N+1];

		dfs(1);

		System.out.println(sb);
	}

	private static void dfs(int m) {
		if (m == M+1) {
			for (int n : list) {
				sb.append(n).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			else {
				if (list.size() == 0 || list.get(list.size()-1) < i) {
					visited[i] = true;
					list.add(i);
					dfs(m+1);
					list.remove(list.size()-1);
					visited[i] = false;
				}
			}
		}
	}
}
