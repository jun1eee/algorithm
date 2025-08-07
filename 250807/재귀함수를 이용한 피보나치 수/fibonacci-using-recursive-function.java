import java.util.Scanner;

public class Main {
    public static int f(int n){
        if (n==1 || n==2) return 1;
        return f(n-1) + f(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
    }
}