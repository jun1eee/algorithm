import java.io.*;
import java.util.*;

public class Solution {
	private static int N, X, M;
	private static int[] arr, answer;
	private static int[][] memo;
	private static int maxSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N];
			memo = new int[M][3];
			answer = new int[N];
			maxSum = -1;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				memo[i][0] = Integer.parseInt(st.nextToken()) - 1;
				memo[i][1] = Integer.parseInt(st.nextToken()) - 1;
				memo[i][2] = Integer.parseInt(st.nextToken());
			}

			dfs(0);

			sb.append("#").append(t).append(" ");
			if (maxSum == -1) {
				sb.append(-1);
			} else {
				for (int i = 0; i < N; i++) {
					sb.append(answer[i]).append(" ");
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	private static void dfs(int index) {
		if (index == N) {
			for (int i = 0; i < M; i++) {
				int checkSum = 0;
				for (int j = memo[i][0]; j <= memo[i][1]; j++) {
					checkSum += arr[j];
				}
				if (checkSum != memo[i][2])
					return;
			}
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += arr[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
				answer = Arrays.copyOf(arr, N);
			}
			return;
		}
		for (int i = 0; i <= X; i++) {
			arr[index] = i;
			dfs(index + 1);
		}
	}
}
