import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[10];

        for (int i=1; i<=n; i++){
            int m = sc.nextInt();
            arr[m]++;
        }
        for (int i=1; i<=9; i++){
            System.out.println(arr[i]);
        }
        // Please write your code here.
    }
}