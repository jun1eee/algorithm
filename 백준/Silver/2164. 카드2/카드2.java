import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        
        while (queue.size() > 1) {
            queue.poll();
            int temp = queue.poll();
            queue.offer(temp);
        }
        
        System.out.println(queue.poll());
    }
}
