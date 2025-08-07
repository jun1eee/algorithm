import java.util.Scanner;
public class Main {
    public static int f(int[] arr, int n){
        if (n==1) return arr[0];
        return Math.max(f(arr,n-1), arr[n-1]); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(f(arr,n));
    }
}