import java.io.*;
import java.util.*;

public class SWEA_1959_두개의숫자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arrN = new int[N];
			int[] arrM = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arrN[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arrM[i] = Integer.parseInt(st.nextToken());
			}
			
			long max = Integer.MIN_VALUE;
			
			for (int i = 0; i <= Math.abs(N-M); i++) {
				long sum = 0;
				if (N <= M) {
					for (int j = 0; j < arrN.length; j++) {
						sum += arrM[i+j]*arrN[j];
					}
				} else {
					for (int j = 0; j < arrM.length; j++) {
						sum += arrN[i+j]*arrM[j];
					}
				}
				max = Math.max(max, sum);
			}
			System.out.println("#" + t + " " + max);

		}
	}
}
