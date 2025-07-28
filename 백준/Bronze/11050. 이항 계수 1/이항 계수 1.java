import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = 1;
		int c = a - b;

		while (a >= 1) {
			m *= a;
			a--;
		}
		while (b >= 1) {
			m /= b;
			b--;
		}
		while (c >= 1) {
			m /= c;
			c--;
		}
		
		System.out.println(m);
	}
}
