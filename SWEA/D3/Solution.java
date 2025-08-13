import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			boolean[][] visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxCnt = 1;
			int smallest = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					int r = i;
					int c = j;
					int start = arr[r][c];
					int temp = start;
					int cnt = 1;
					visited[r][c] = true;
					while (true) {
						boolean check = false;
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							
							if (arr[nr][nc] == temp + 1) {
								r = nr;
								c = nc;
								temp = arr[r][c];
								visited[r][c] = true;
								cnt++;
								check = true;
								break;
							}
							
						}
						if(!check) break;
					}
					if (cnt > maxCnt) {
						maxCnt = cnt;
						smallest = start;
					} else if (cnt == maxCnt && start < smallest) {
						smallest = start;
					}
					
				}
			}
			System.out.println("#" + t + " " + smallest + " " + maxCnt);
			System.out.println();
		}

	}

}
