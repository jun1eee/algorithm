import java.util.Scanner;
public class Main {
    public static void printStars1(int n) {
        if (n==0){
            return;
        }
        printStars1(n-1);
        System.out.print(n+ " ");
    }
    public static void printStars2(int n) {
        if (n==0){
            return;
        }
        System.out.print(n + " ");
        printStars2(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStars1(7);
        System.out.println();
        printStars2(7);
    }
}