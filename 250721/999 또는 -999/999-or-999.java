import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (true){
            int n = sc.nextInt();
            
            if (n == 999 || n == -999) break;
            if (max <= n) max = n;
            if (min >= n) min = n;
        }
        System.out.println(max + " " + min);
        // Please write your code here.
    }
}