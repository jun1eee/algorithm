import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[b];

        while (a>=1) {
            arr[a%b]++;
            a = a/b;
        }
        int sum = 0;
        for (int i=0; i<b; i++){
            sum += arr[i]*arr[i];
        }
        System.out.print(sum);
        // Please write your code here.
    }
}