import java.util.Scanner;

public class Main {
    public static int[] arr = new int[10];
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }
    public static int lcm(int a, int b) {
        return a* (b/gcd(a,b));
    }
    public static int lcmArray(int n) {
        if (n==0) return arr[0];
        return lcm(arr[n], lcmArray(n-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(lcmArray(n-1));
    }
}