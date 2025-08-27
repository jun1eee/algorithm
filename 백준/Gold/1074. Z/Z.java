import java.io.*;
import java.util.*;

public class Main {
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        cnt = 0;
        solve(N, r, c);
        System.out.println(cnt);
    }

    static void solve(int n, int r, int c) {
        if (n == 0) return;                  // 1x1이면 더할 것 없음
        int half = 1 << (n - 1);             // 2^(n-1)
        int quad = (r >= half ? 2 : 0) + (c >= half ? 1 : 0); // 0,1,2,3
        cnt += quad * (half * half);
        solve(n - 1, r % half, c % half);
    }
}
