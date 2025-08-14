import java.io.*;
import java.util.*;

public class SWEA_6485_삼성시의버스노선 {
	 public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int T = Integer.parseInt(br.readLine());
		 for (int t = 1; t <= T; t++) {
			 int N = Integer.parseInt(br.readLine());
			 int[] arr = new int[5001];
			 
			 for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for (int j = a; j <= b; j++) {
					arr[j]++;
				}
			 }
			 int P = Integer.parseInt(br.readLine());
			 StringBuilder sb = new StringBuilder();
			 sb.append("#").append(t).append(" ");
			 for (int i = 0; i < P; i++) {
				int c = Integer.parseInt(br.readLine());
				sb.append(arr[c]).append(" ");
			 }
			 System.out.println(sb);
		 }
    }
}