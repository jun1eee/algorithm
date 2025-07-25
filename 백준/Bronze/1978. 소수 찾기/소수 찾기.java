import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = 0;
			int k = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= k; j++) {
				if(k%j==0) num++;
			}
			if (num==2) cnt++;
		}
		System.out.println(cnt);
	}
}
