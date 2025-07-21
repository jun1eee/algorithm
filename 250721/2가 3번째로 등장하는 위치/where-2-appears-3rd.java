import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        int num = 0;

        for (int i=0; i<n; i++){
            if (arr[i]==2) cnt++;
            if (cnt==3) {
                num = i+1;
                break;
            }
        }
        System.out.print(num);

        // Please write your code here.
    }
}