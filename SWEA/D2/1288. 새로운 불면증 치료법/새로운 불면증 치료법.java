import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] arr = new boolean[10];
			int cnt = 1;
			while (true) {
				int num = cnt * N;
				boolean check = true;
				while (num > 0) {
					arr[num % 10] = true;
					num /= 10;
				}
				for (int i = 0; i <= 9; i++) {
					if (arr[i] == false) {
						check = false;
						break;
					}
				}
				if (check == true)
					break;
				cnt++;
			}
			System.out.println("#" + t + " " + cnt*N);
		}
	}
}
