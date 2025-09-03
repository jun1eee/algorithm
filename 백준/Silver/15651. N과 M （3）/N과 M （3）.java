import java.io.*;
import java.util.*;


public class Main {
	public static int N,M;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs(int i) {
		if (i == M) {
			for (int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for (int j = 0; j < N; j++) {
			arr[i] = j+1;
			dfs(i+1);
		}
	}
}



