import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int a = 0;
        
        for (int i = 0; i < 10; i++) {
            int input = sc.nextInt();
            if (input == 0) {
                break; 
            }
            arr[i] = input;
            a++; 
        }

        for (int i = a - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
