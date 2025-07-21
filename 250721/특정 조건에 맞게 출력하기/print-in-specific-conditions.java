import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int i = 0;
        while (true){
            int n = sc.nextInt();
            if (n%2==0 && n!=0){
                arr[i] = n/2;
            }else if (n%2==1){
                arr[i] = n+3;
            }else {
                break;
            }
            i++;
        }
        for (int j=0; j<i; j++){
            System.out.print(arr[j]+" ");
        }
        
        // Please write your code here.
    }
}