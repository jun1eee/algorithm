import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] map;
    public static int[][] distance;
    public static final int INF = (int) 1e9;

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            map = new int[n][n];
            distance = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = INF;
                }
            }

            dijkstra();
            sb.append("Problem ").append(cnt++).append(": ").append(distance[n - 1][n - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[0][0] = map[0][0];
        pq.offer(new Node(0, 0, distance[0][0]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 구버전 상태 스킵
//            if (node.distance > distance[node.x][node.y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    int cost = node.distance + map[nx][ny];
                    if (cost < distance[nx][ny]) {
                        distance[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
        }
    }
}
