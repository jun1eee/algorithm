import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];

        while (true){
            int n = sc.nextInt();
            arr[n/10]++;
            if (n==0) break;
        }

        for (int i=10; i>=1; i--){
            System.out.println(10*i + " - "+ arr[i]);
        }
        // Please write your code here.
    }
}