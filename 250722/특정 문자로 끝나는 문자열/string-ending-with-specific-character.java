import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];

        for (int i=0; i<10; i++){
            arr[i] = sc.next();
        }
        char a = sc.next().charAt(0);
        int b = -1;
        for (int i=0; i<10; i++){
            int len = arr[i].length();
            if (arr[i].charAt(len-1)==a){
                System.out.println(arr[i]);
                b = 1;
            }
        }
        if (b==-1) System.out.println("None");
        // Please write your code here.
    }
}