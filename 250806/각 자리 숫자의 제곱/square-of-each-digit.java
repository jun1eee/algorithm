import java.util.Scanner;
public class Main {
    public static int sumSquare(int n){
        if (n < 10) return n*n;
        return sumSquare(n/10) + (n%10)*(n%10); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumSquare(n));
    }
}