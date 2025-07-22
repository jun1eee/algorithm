import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.next().length();
        int b = sc.next().length();
        int c = sc.next().length();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if (max < a) max = a;
        if (max < b) max = b;
        if (max < c) max = c;

        if (min > a) min = a;
        if (min > b) min = b;
        if (min > c) min = c;

        System.out.print(max-min);
        // Please write your code here.
    }
}