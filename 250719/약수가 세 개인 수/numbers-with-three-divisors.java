import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int cnt = 0;

        for (int i=start; i<=end; i++){
            int div = 0;
            for (int j=1; j<=i; j++){
                if (i%j==0){
                    div ++;
                }
            }
            if (div == 3){
                cnt ++;
            }
        }
        System.out.println(cnt);
        // Please write your code here.
    }
}