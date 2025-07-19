import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int cnt = 0;

        for(int i=0; i<10; i++){
            int n = sc.nextInt();
            if (n==0) break;
            arr[i] = n;
            cnt++;
        }
        int sum = 0;
        for(int i=0; i<cnt; i++){
            sum += arr[i];
        }
        double avg = (double)sum/cnt;

        System.out.printf("%d %.1f", sum, avg);
        // Please write your code here.
    }
}