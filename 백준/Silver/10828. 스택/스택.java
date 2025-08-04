import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			switch(str) {
			case "push" :
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
				
			case "pop" :
				if (stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.pop());					
				}
				break;
				
			case "size" :
				System.out.println(stack.size());
				break;
				
			case "empty" :
				System.out.println(stack.isEmpty() ? 1: 0);
				break;
				
			case "top" :
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());					
				}
				break;
			}
		}
	}
}
