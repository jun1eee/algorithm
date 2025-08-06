import java.util.Scanner;

public class Main {
    public static int sumFunc(int n) {
        if (n == 1) return 1;
        return sumFunc(n-1) + n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumFunc(n));
    }
}