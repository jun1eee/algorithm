import java.util.*;
import java.io.*;

public class Solution {
	private static List<Integer>[] list;
	private static boolean[] visited;
	private static int resultMax;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			list = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			visited = new boolean[101];
			bfs(start);
			sb.append("#").append(t).append(" ").append(resultMax).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			resultMax = 0;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				resultMax = Math.max(cur, resultMax);

				for (int num : list[cur]) {
					if (visited[num])
						continue;
					visited[num] = true;
					q.add(num);
				}
			}
		}
	}
}