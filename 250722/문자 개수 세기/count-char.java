import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String line = br.readLine();
        char target = br.readLine().charAt(0);
        int cnt = 0;

        for(int i=0; i<line.length(); i++){
            if (line.charAt(i)== target) cnt ++;
        }

        System.out.println(cnt);

        // Please write your code here.
    }
}