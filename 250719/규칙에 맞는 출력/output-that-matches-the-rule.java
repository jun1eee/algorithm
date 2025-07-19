import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=n; i>=1; i--){
            for (int j=i; j<=n; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        // Please write your code here.
    }
}