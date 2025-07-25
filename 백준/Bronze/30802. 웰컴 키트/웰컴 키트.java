import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] size = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 6; i++) {
			if (size[i]%T == 0) sum += size[i]/T;
			else sum += size[i]/T + 1;
		}
		System.out.println(sum);
		System.out.println(N/P + " " + N%P);
	}
}
