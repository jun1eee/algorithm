import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=2; i<=n; i++){
            int div = 0;

            for (int j=1; j<=i; j++){
                if (i%j==0){
                    div++;
                }
            }
            if (div ==2 ){
                System.out.print(i+" ");
            }
        }
    }
}