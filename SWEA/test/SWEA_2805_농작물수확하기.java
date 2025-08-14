import java.io.*;
import java.util.*;

public class SWEA_2805_농작물수확하기 {
	 public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder out = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine().trim());
		 for (int t = 1; t <= T; t++) {
			 int N = Integer.parseInt(br.readLine().trim());
			 int center = N / 2;
			 int sum = 0;

			 for (int i = 0; i < N; i++) {
				 char[] row = br.readLine().trim().toCharArray();
				 int dist = Math.abs(center - i);
				 int start = dist;          // = center - (center - dist)
				 int end = N - 1 - dist;    // = center + (center - dist)

				 for (int j = start; j <= end; j++) {
	                    sum += row[j] - '0';
				 }
	          }
	          out.append('#').append(t).append(' ').append(sum).append('\n');
	     }
	     System.out.print(out);
    }
}