import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int i = 0 ;

        while (true){
            int a = sc.nextInt();
            if (a == 0) break;
            arr[i] = a;
            i++;
        }
        System.out.print(arr[i-1]+arr[i-2]+arr[i-3]);
        // Please write your code here.
    }
}