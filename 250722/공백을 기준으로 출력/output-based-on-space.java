import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        for (int i=0; i<a.length(); i++){
            if (a.charAt(i)==' ') continue;
            System.out.print(a.charAt(i));
        }
        for (int i=0; i<b.length(); i++){
            if (b.charAt(i)==' ') continue;
            System.out.print(b.charAt(i));
        }
        // Please write your code here.
    }
}