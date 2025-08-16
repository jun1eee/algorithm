import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<Integer>[] subjects;
	private static int[] inDegree; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		subjects = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			subjects[i] = new ArrayList<>();
		}
		inDegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			subjects[A].add(B);
			inDegree[B]++;
		}
		topologySort();
	}

	public static void topologySort() {
		StringBuilder sb = new StringBuilder();
//		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		int N = subjects.length -1;
		int[] semester = new int[N+1];

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
				semester[i] = 1;
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
//			result.add(now);

			for (int nxt : subjects[now]) {
				inDegree[nxt]--;
				semester[nxt] = Math.max(semester[nxt], semester[now] + 1);
				if (inDegree[nxt] == 0) {
					queue.offer(nxt);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(' ');
        }
        System.out.println(sb);
	}
}