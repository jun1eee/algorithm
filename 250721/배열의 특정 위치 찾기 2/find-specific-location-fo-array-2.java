import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum1 = 0;
        int sum2 = 0;
        int n = 0;
        int[] arr = new int[10];
        
        for (int i=0; i<10; i++){
            arr[i] = sc.nextInt();
        }
        
        for (int i=0; i<10; i++){
            if (i%2==0) {
                sum1 += arr[i];
            } else {
                sum2 += arr[i];
            }
        }

        if (sum1>= sum2) n = sum1-sum2;
        else n = sum2-sum1;

        System.out.println(n);
        // Please write your code here.
    }
}