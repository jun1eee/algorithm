import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[10];
        int cnt = 0;

        for(int i=0; i<10; i++){
            arr[i] = n*(i+1);
        }

        for (int i=0; i<10; i++){
            if (cnt==2) break;
            if (arr[i]%5==0) cnt++;
            System.out.print(arr[i]+" "); 
        }
        // Please write your code here.
    }
}