import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr1, arr2;
	static boolean[] used;
	static long win, lose;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr1 = new int[9];
			boolean[] check = new boolean[19];
			arr2 = new int[9];
			for (int i = 0; i < 9; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr1[i] = tmp;
				check[tmp] = true;
			}
			int p = 0;
			for (int i = 1; i <= 18; i++) {
				if (!check[i]) {
					arr2[p++] = i;
				}
			}
			used = new boolean[9];
			win = lose = 0;
			dfs(0, 0, 0);
			sb.append('#').append(t).append(' ')
            .append(win).append(' ').append(lose).append('\n');
		}
      System.out.print(sb.toString());
	}

	public static void dfs(int idx, int kScore, int iScore) {
		if (idx == 9) {
			if (kScore > iScore)
				win++;
			else if (kScore < iScore)
				lose++;
			return;
		}

		int ky = arr1[idx];
		for (int i = 0; i < 9; i++) {
			if (used[i])
				continue;
			used[i] = true;

			int iy = arr2[i];
			if (ky > iy)
				dfs(idx + 1, kScore + ky + iy, iScore);
			else {
				dfs(idx + 1, kScore, iScore + ky + iy);
			}
			used[i] = false;
		}
	}
}