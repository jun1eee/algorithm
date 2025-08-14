import java.io.*;
import java.util.*;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			
			char tmp = str.charAt(0);
			int cnt = (str.charAt(0)=='0') ? 0 : 1;
			
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(i) == tmp) continue;
				else {
					tmp = str.charAt(i);
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
