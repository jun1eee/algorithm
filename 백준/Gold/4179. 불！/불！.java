import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fireT;                 // 불의 최단 도착 시간
    static final int INF = 1_000_000_000;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean in(int r, int c) { return 0 <= r && r < R && 0 <= c && c < C; }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireT = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(fireT[i], INF);

        ArrayDeque<int[]> fq = new ArrayDeque<>();  // 불 큐 (다중 시작점)
        int sr = -1, sc = -1;                       // 지훈 시작점

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = s.charAt(j);
                map[i][j] = ch;
                if (ch == 'J') { sr = i; sc = j; }
                else if (ch == 'F') { fireT[i][j] = 0; fq.add(new int[]{i, j}); }
            }
        }

        // 1) 불 BFS (다중 시작점)
        while (!fq.isEmpty()) {
            int[] cur = fq.poll();
            int r = cur[0], c = cur[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (!in(nr, nc) || map[nr][nc] == '#') continue;
                if (fireT[nr][nc] != INF) continue;
                fireT[nr][nc] = fireT[r][c] + 1;
                fq.add(new int[]{nr, nc});
            }
        }

        // 2) 지훈 BFS
        int ans = bfsJihun(sr, sc);
        System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
    }

    static int bfsJihun(int sr, int sc) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(dist[i], -1);

        dist[sr][sc] = 0;
        q.add(new int[]{sr, sc});

        // 시작이 가장자리면 한 걸음에 탈출
        if (sr == 0 || sc == 0 || sr == R - 1 || sc == C - 1) return 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int t = dist[r][c];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                int nt = t + 1;

                // 바깥으로 나가면 탈출
                if (!in(nr, nc)) return nt;

                if (map[nr][nc] == '#' || dist[nr][nc] != -1) continue;
                // 불이 같은 시각 또는 더 일찍 오면 못 감
                if (fireT[nr][nc] <= nt) continue;

                dist[nr][nc] = nt;
                q.add(new int[]{nr, nc});
            }
        }
        return -1;
    }
}
