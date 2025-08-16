import java.io.*;
import java.util.*;

public class SWEA_1859_백만장자프로젝트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			long profit = 0;
			long buy = 0;
			int cnt = 0;
			int max = price[N-1];
			for (int i = N-2; i >= 0; i--) {
				if (max >= price[i]) {
					buy += price[i];
					cnt++;
				} else {
					profit += (long)max * cnt - buy;
					max = price[i];
					buy = 0;
					cnt = 0;
				}
			}
			profit += (long)max * cnt - buy;
			System.out.println("#" + t + " " + profit);
		}
	}
}