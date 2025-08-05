import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("push_front")){
                int num = sc.nextInt();
                list.addFirst(num);
            }
            else if (command.equals("push_back")){
                int num = sc.nextInt();
                list.addLast(num);
            }
            else if (command.equals("pop_front")){
                System.out.println(list.pollFirst());
            }
            else if (command.equals("pop_back")){
                System.out.println(list.pollLast());
            }
            else if (command.equals("size")){
                System.out.println(list.size());
            }
            else if (command.equals("empty")){
                System.out.println(list.isEmpty() ? 1 : 0);
            }
            else if (command.equals("front")){
                System.out.println(list.peekFirst());
            }
            else if (command.equals("back")){
                System.out.println(list.peekLast());
            }
        }
    }
}