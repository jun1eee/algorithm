import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] arr, res;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		res = new int[M];
		dfs(0);
		System.out.println(sb.toString());
	}

	private static void dfs(int m) {
		if (m == M) {
			for (int r : res) {
				sb.append(r).append(" ");
			}
			sb.append('\n');
			return;
		}
		int before = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			if (before != arr[i]) {
				before = arr[i];
				visited[i] =true;
				res[m] = arr[i];
				dfs(m+1);
				visited[i] = false;
			}
		}
	}
}
