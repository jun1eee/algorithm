import java.util.Scanner;
public class Main {
    public static void f(int n){
        if(n==0){
            return;
        }
        System.out.println("HelloWorld");
        f(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
    }
}