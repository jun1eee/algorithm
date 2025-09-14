import java.io.*;
import java.util.*;

public class Main {
	private static int N, S, cnt;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		if (S == 0)
			cnt--;
		dfs(0, 0);
		System.out.println(cnt);
	}

	private static void dfs(int n, int sum) {
		if (n == N) {
			if (sum == S)
				cnt++;
			return;
		}

		dfs(n + 1, sum + arr[n]);
		dfs(n + 1, sum);
	}
}
