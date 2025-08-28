import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer>[] edges;
	static int[] indegree;
	static int[] times;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N + 1];
		indegree = new int[N + 1];
		times = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			edges[n] = new ArrayList<>();
		}

		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			times[n] = time;
			int T = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= T; i++) {
				int num = Integer.parseInt(st.nextToken());
				edges[num].add(n);
				indegree[n]++;
			}
		}

		System.out.println(topologySort());
	}

	public static int topologySort() {
		Queue<Integer> q = new ArrayDeque<>();
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				result[i] = times[i];
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : edges[cur]) {
				result[next] = Math.max(result[next], result[cur] + times[next]);
				indegree[next]--;
				if (indegree[next] == 0)
					q.add(next);
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; i++)
			ans = Math.max(ans, result[i]);
		return ans;
	}
}
