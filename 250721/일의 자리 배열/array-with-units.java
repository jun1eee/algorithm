import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        arr[0] = 2;
        arr[1] = 5;
        System.out.print(arr[0]+" "+arr[1]+" ");
        for (int i=2; i<10; i++){
            arr[i] = (arr[i-1] + arr[i-2])%10;
            System.out.print(arr[i]+" ");
        }
        // Please write your code here.
    }
}