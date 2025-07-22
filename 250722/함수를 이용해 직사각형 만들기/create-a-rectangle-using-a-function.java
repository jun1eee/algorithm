import java.util.Scanner;

public class Main {
    public static void printOne(int n, int m){
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print("1");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();

        printOne(rowNum, colNum);
        // Please write your code here.
    }
}