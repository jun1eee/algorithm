import java.io.*;
import java.util.*;

public class Solution {
    static int N, ans, sr, sc;
    static int[][] map;
    static boolean[][] visited;   // 경로상의 좌표 방문
    static boolean[] used;        // 먹은 디저트 번호(0~100)
    static final int[] dr = { 1, 1, -1, -1 };
    static final int[] dc = { 1, -1, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = -1;
            // 모든 시작점 시도 (가장자리는 사실상 불리하지만 DFS가 걸러줌)
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    visited = new boolean[N][N];
                    used = new boolean[101];
                    sr = r; sc = c;
                    visited[r][c] = true;
                    used[map[r][c]] = true;
                    dfs(r, c, 0, 1); // (현재 r,c), 방향 0부터 시작, 먹은 개수 1
                }
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.print(sb);
    }

	static void dfs(int r, int c, int dir, int cnt) {
	    for (int ndir = 0; ndir < 4; ndir++) {
	        // 직진(dir) 또는 다음 방향(dir+1)만 허용
	        if (ndir < dir || ndir > dir + 1) continue;
	        int nr = r + dr[ndir];
	        int nc = c + dc[ndir];
	        // 사각형 닫기: 시작점 복귀 + 마지막 변(ndir==3) + 최소 4개 이상
	        if (nr == sr && nc == sc && ndir == 3 && cnt >= 4) {
	            ans = Math.max(ans, cnt);
	            continue;
	        }

	        // 경계/방문/디저트 중복 체크
	        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
	        if (visited[nr][nc]) continue;
	        int d = map[nr][nc];
	        if (used[d]) continue;
	        visited[nr][nc] = true;
	        used[d] = true;
	        dfs(nr, nc, ndir, cnt + 1);
	        visited[nr][nc] = false;
	        used[d] = false;
	    }
	}
}
