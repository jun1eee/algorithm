import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int asc = 1;
        int des = 1;
        int max = 1;

        for (int i = 1; i < N; i++) {  // i = 0이 아닌 i = 1부터 시작
            if (arr[i-1] < arr[i]) {
                asc++;
                des = 1;
            } else if (arr[i-1] > arr[i]) {
                des++;
                asc = 1;
            } else { // arr[i-1] == arr[i]
                asc++;
                des++;
            }
            
            max = Math.max(max, Math.max(asc, des));
        }
        
        System.out.println(max);
    }
}