import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[5][3];

        for (int i=0; i<5; i++){
            for (int j=0; j<3; j++){
                arr[i][j] = sc.next().charAt(0);
            }
        }

        for (int i=0; i<5; i++){
            for (int j=0; j<3; j++){
                char a = arr[i][j];
                char upper = (char)(a - 32);
                System.out.print(upper + " ");
            }
            System.out.println();
        }
        
        // Please write your code here.
    }
}