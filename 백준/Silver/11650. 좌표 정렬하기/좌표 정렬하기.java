import java.util.*;
import java.io.*;

public class Main {
	public static class xyValue {
		int x;
		int y;
		
		public xyValue(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return  x + " " + y + "\n";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		xyValue[] v = new xyValue[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v[i] = new xyValue(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(v, new Comparator<xyValue>() {

			@Override
			public int compare(xyValue o1, xyValue o2) {
				if (o1.x == o2.x) return o1.y - o2.y;
				return o1.x - o2.x;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(v[i]);
		}
		System.out.println(sb);
	}
}
