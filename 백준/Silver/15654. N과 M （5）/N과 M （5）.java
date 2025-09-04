import java.util.*;
import java.io.*;

public class Main {
	private static int N, M;
	private static int[] arr, res;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		res = new int[M];
		visited = new boolean[N];
		dfs(0);
		System.out.println(sb.toString());
	}

	private static void dfs(int m) {
		if (m == M) {
			for (int a : res) {
				sb.append(a).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			res[m] = arr[i];
			dfs(m+1);
			visited[i] = false;
		}
	}
}
