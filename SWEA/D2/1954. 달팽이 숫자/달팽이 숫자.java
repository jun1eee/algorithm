import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];

            int num = 1;
            int index = 0;
            int end = N - 1;

            while (index <= end) {
                for (int i = index; i <= end; i++) {
                    arr[index][i] = num++;
                }

                for (int i = index + 1; i <= end; i++) {
                    arr[i][end] = num++;
                }

                for (int i = end - 1; i >= index; i--) {
                    arr[end][i] = num++;
                }

                for (int i = end - 1; i > index; i--) {
                    arr[i][index] = num++;
                }

                index++;
                end--;
            }

            System.out.println("#" + (t + 1));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}