import java.io.*;
import java.util.*;

public class SWEA_12712_파리퇴치3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			long sumMax = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long sum1 = arr[i][j];
					long sum2 = arr[i][j];
					
					for (int k = 0; k < 4; k++) {
						int r = i;
						int c = j;
						for (int l = 0; l < M-1; l++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (nr<0 || nc<0 || nr>=N ||nc>=N) continue;
							sum1 += arr[nr][nc];
							r = nr;
							c = nc;
						}	
					}
					for (int k = 4; k < 8; k++) {
						int r = i;
						int c = j;
						for (int l = 0; l < M-1; l++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if (nr<0 || nc<0 || nr>=N ||nc>=N) continue;
							sum2 += arr[nr][nc];
							r = nr;
							c = nc;
						}	
					}
					sumMax = Math.max(sumMax, Math.max(sum1, sum2));
				}
			}
			System.out.println("#" + t + " " + sumMax);
			
		}
	}
}