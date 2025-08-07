import java.util.Scanner;
public class Main {
    public static int f(int n) {
        if (n==1) return 0;
        if (n%2==0) return f(n/2) + 1;
        else return f(3*n+1) + 1;    
    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
    }
}