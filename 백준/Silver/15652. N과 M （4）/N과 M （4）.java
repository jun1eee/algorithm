import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Integer> list;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		dfs(1, 1);
		System.out.println(sb);
	}

	private static void dfs(int n, int m) {
		if (m == M + 1) {
			for (int l : list) {
				sb.append(l).append(" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = n; i <= N; i++) {
			list.add(i);
			dfs(i, m+1);
			list.remove(list.size()-1);
		}
	}
}