import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 'A';

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                System.out.print((char)x);
                x++;
            }
            System.out.println();
        }
        // Please write your code here.
    }
}