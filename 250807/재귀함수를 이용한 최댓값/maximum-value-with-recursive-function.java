import java.util.Scanner;
public class Main {
    public static int[] arr = new int[100];
    public static int f(int n){
        if (n==0) return arr[0];
        return Math.max(f(n-1), arr[n]); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(f(n-1));
    }
}