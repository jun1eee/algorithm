import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int k = 1;
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                arr[i][j] = k++;
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        // Please write your code here.
    }
}