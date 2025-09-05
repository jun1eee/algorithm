import java.io.*;
import java.util.*;

public class Solution {
    private static int N, X, M;
    private static int[] arr, answer;
    private static int[][] memo; // memo[i][0]=L-1, memo[i][1]=R-1, memo[i][2]=S (모두 0-based로 변환되어 있음)
    private static int maxSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N];
            memo = new int[M][3];
            answer = new int[N];
            maxSum = -1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                memo[i][0] = Integer.parseInt(st.nextToken()) - 1; // L -> 0-based
                memo[i][1] = Integer.parseInt(st.nextToken()) - 1; // R -> 0-based
                memo[i][2] = Integer.parseInt(st.nextToken());     // S
            }

            dfs(0, 0); // depth=0, curSum=0

            sb.append("#").append(t).append(" ");
            if (maxSum == -1) {
                sb.append(-1);
            } else {
                for (int i = 0; i < N; i++) sb.append(answer[i]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int curSum) {
        if (depth == N) {
            // 모든 칸 채웠으면 제약 체크
            for (int i = 0; i < M; i++) {
                int checkSum = 0;
                for (int j = memo[i][0]; j <= memo[i][1]; j++) {
                    checkSum += arr[j];
                }
                if (checkSum != memo[i][2]) return;
            }
            // 합은 curSum을 그대로 사용
            if (curSum > maxSum) {
                maxSum = curSum;
                answer = Arrays.copyOf(arr, N);
            }
            return;
        }

        for (int v = 0; v <= X; v++) {
            arr[depth] = v;
            dfs(depth + 1, curSum + v);
        }
    }
}
