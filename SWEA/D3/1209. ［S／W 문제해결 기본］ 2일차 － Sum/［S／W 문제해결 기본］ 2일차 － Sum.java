import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] result = new int[10];
		
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int colmax = 0;
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				if(sum>colmax) {
					colmax = sum;
				}
			}
			
			int rowmax = 0;
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				if(sum>rowmax) {
					rowmax = sum;
				}
			}
			
			int leftline = 0;
			int rightline = 0;
			for (int i = 0; i < 100; i++) {
				leftline += arr[i][i];
				rightline += arr[i][99-i];
			}

			result[t] = Math.max(Math.max(rowmax, colmax), Math.max(leftline, rightline));
		}
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("#"+i+" " +result[i-1]);
		}		
	}
}
