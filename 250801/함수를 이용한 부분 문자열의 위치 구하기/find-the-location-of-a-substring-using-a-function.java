import java.util.Scanner;
public class Main {
    public static int findIndex(String text, String pattern){
        return text.indexOf(pattern);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        System.out.println(findIndex(text, pattern));
    }
}