import java.io.*;
import java.util.*;

public class SWEA_14510_나무높이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxLength = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxLength = Math.max(maxLength, arr[i]);
			}
			
			for (int i = 0; i < N; i++) {
				arr[i] = maxLength - arr[i];
			}
			
			int cnt1 = 0;
			int cnt2 = 0;
			
			for (int i = 0; i < N; i++) {
				int temp = arr[i];
				if (temp%3==0) {
					cnt1 += temp/3;
					cnt2 += temp/3;
				} else if (temp%3==1) {
					
				}
			}
			
		}
	}

}
