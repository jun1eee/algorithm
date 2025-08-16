import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] price = new int[N];
            int idx = 0;
            StringTokenizer st = null;
            while (idx < N) {
                if (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                else
                    price[idx++] = Integer.parseInt(st.nextToken());
            }

            long profit = 0L;
            int max = price[N - 1];          
            for (int i = N - 2; i >= 0; i--) {
                if (price[i] <= max) {
                    profit += (max - price[i]);
                } else {
                    max = price[i];             
                }
            }

            out.append('#').append(t).append(' ').append(profit).append('\n');
        }
        System.out.print(out);
    }
}
