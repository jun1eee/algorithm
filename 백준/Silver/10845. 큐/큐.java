import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int back = -1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			switch (str) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
				back = num;
				break;
				
			case "pop":
				if (q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.poll());
				}
				break;

			case "size":
				System.out.println(q.size());
				break;

			case "empty":
				System.out.println(q.isEmpty() ? 1 : 0);
				break;

			case "front":
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
				break;

			case "back":
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(back);
				break;
			}
		}
	}
}
