import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			boolean isValid = true;
			Stack<Character> stack = new Stack<>();
			
			if (s.charAt(0) == '.') {
				break;
			}else {
				for (int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == '(' || s.charAt(i) == '[') {
						stack.push(s.charAt(i));
					} else if (s.charAt(i) == ')'){
						if (stack.isEmpty() || stack.pop() != '(') {
	                        isValid = false;
	                        break;
	                    }
	                } else if (s.charAt(i) == ']') {
	                	if (stack.isEmpty()  || stack.pop() != '[') {
	                        isValid = false;
	                        break;
	                    }
					}
				}
				
				if (isValid && stack.isEmpty()) {
	                sb.append("yes\n");
	            } else {
	                sb.append("no\n");
	            }
			}
		}
		System.out.println(sb);
	}
}
