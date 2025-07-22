import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        if (s1.length()>s2.length()) System.out.print(s1 + " " + s1.length);
        else if (s1.length()<s2.length()) System.out.print(s2 + " " + s2.length);
        else System.out.print("same");
        // Please write your code here.
    }
}