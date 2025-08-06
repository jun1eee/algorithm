import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++){
            String str = sc.next();
            if (str.equals("push")){
                int num = sc.nextInt();
                stack.push(num);
            } else if (str.equals("pop")){
                System.out.println(stack.pop());
            } else if (str.equals("empty")){
                if (stack.empty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str.equals("size")){
                System.out.println(stack.size());
            } else if (str.equals("top")){
                System.out.println(stack.peek());
            }

        }
    }
}