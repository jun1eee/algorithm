import java.util.Scanner;
public class Main {
    public static boolean func(int n){
        if (n%2==0 && (n/10+n%10)%5==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(func(n)? "Yes":"No");
    }
}