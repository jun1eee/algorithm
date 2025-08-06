import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if (ch == '('){
                stack.push(ch);
            } else if (ch == ')'){
                if (stack.isEmpty()){
                    System.out.println("No");
                    return;
                }
                else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()){
                System.out.println("Yes");
        } else {
                System.out.println("No");
        }
    }
}