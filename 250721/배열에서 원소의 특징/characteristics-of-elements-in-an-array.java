import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int[] arr = new int[10];
        int cnt = 0;

        for (int i=0; i<10; i++){
            int n = sc.nextInt();
            if (n%3==0) break;
            arr[i] = n;
            cnt++;
        }
        System.out.print(arr[cnt-1]);
        // Please write your code here.
    }
}