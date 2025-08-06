import java.util.Scanner;
public class Main {
    public static int n = 0;
    public static int cnt(int n){
        if (n == 1) return 0;

        if (n%2==0) {
            return cnt(n/2) + 1;
        } else {
            return cnt(n/3) + 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(cnt(n));
    }
}