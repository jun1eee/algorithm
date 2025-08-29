import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T; // 테스트 케이스의 수
    static int N; // 깃발의 행 수
    static int M; // 깃발의 열 수
    static char[][] board; // 깃발의 색 정보를 담은 2차원 배열
    static int min; // 새로 칠해야 하는 최소 칸의 개수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            board = new char[N + 1][M];

            for (int i = 1; i <= N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            int toWhiteCnt = 0; // 흰색으로 칠해져야 하는 칸의 개수
            int toBlueCnt;
            int toRedCnt;

            // 첫 번째 줄부터 일정 부분까지는 흰색으로 칠해져야 함
            for (int i = 1; i <= N - 2; i++) {
                toWhiteCnt += toColor('W', i);
                toBlueCnt = 0;

                // 두 번째 줄부터 일정 부분까지는 파란색으로 칠해져야 함
                for (int j = i + 1; j <= N - 1; j++) {
                    toBlueCnt += toColor('B', j);
                    toRedCnt = 0;

                    // 나머지 부분은 빨간색으로 칠해져야 함
                    for (int k = j + 1; k <= N; k++) {
                        toRedCnt += toColor('R', k);
                    }

                    min = Math.min(min, toWhiteCnt + toBlueCnt + toRedCnt);
                }
            }
            sb.append("#" + t + " " + min + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int toColor(char color, int r) {
        int cnt = 0;
        for (int c = 0; c < M; c++) {
            if (board[r][c] != color) cnt++;
        }
        return cnt;
    }
}