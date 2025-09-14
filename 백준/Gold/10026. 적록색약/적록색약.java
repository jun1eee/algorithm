import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        // 1) 일반 시야
        int normal = countRegions(map);

        // 2) 적록색약: G -> R 로 맵을 변환한 뒤 같은 BFS 재사용
        char[][] cbMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char ch = map[i][j];
                cbMap[i][j] = (ch == 'G') ? 'R' : ch;
            }
        }
        int colorBlind = countRegions(cbMap);

        System.out.println(normal + " " + colorBlind);
    }

    // 같은 색 연결요소 개수 세기 (BFS, primitive queue)
    static int countRegions(char[][] g) {
        boolean[][] visited = new boolean[N][N];
        int regions = 0;

        // 고정 최대 크기 큐 (객체 생성 없이 빠름)
        int maxQ = N * N;
        int[] qr = new int[maxQ];
        int[] qc = new int[maxQ];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                regions++;

                char color = g[i][j];
                int head = 0, tail = 0;
                visited[i][j] = true;
                qr[tail] = i; qc[tail] = j; tail++;

                while (head < tail) {
                    int r = qr[head], c = qc[head]; head++;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d], nc = c + dc[d];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if (!visited[nr][nc] && g[nr][nc] == color) {
                            visited[nr][nc] = true;
                            qr[tail] = nr; qc[tail] = nc; tail++;
                        }
                    }
                }
            }
        }
        return regions;
    }
}
