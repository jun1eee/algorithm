import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] arr, res;
	public static StringBuilder sb = new StringBuilder();

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
		for (int i = 0; i < N; i++) {
			res[m] = arr[i];
			dfs(m+1);
		}
	}
}
