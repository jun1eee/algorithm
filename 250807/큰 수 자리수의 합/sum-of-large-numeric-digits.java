import java.util.Scanner;
public class Main {
    public static int mulSum(int n){
        if (n==0) return 0;
        return mulSum(n/10)+(n%10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(mulSum(a*b*c));
    }
}