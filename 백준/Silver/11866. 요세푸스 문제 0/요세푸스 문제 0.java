import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		Deque<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		 sb.append("<");
	     int cnt = 1;

	     while (!queue.isEmpty()) {
	        for (int i = 0; i < K - 1; i++) {
	            queue.add(queue.poll());
	        }
	        sb.append(queue.poll());
	        if (!queue.isEmpty()) {
	           sb.append(", ");
	        }
	     }
	     sb.append(">");
	     System.out.println(sb);
	}
}