import java.io.*;
import java.util.*;
 
public class Solution {

	public static class Point {
	    int x, y;

	    public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}

    public static int N, parents[];
    public static double E;
    public static Point[] island;
    public static ArrayList<Edge> edgeList;
    public static class Edge implements Comparable<Edge> {
        int from, to;
        long w;
 
        public Edge(int from, int to, long w) {
            super();
            this.from = from;
            this.to = to;
            this.w = w;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            
            // 섬의 개수
            N = Integer.parseInt(br.readLine());
            island = new Point[N];
            parents = new int[N];
            // 섬들의 x 좌표 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { 
                island[i] = new Point(0, 0);
                island[i].x = Integer.parseInt(st.nextToken());
            }
            // 섬들의 y좌표 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) 
                island[i].y = Integer.parseInt(st.nextToken());
            // 세율
            E = Double.parseDouble(br.readLine());
            
            // 모든 간선의 비용을 저장
            edgeList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long distX = Math.abs(island[i].x - island[j].x);
                    long distY = Math.abs(island[i].y - island[j].y); 
                    edgeList.add(new Edge(i, j, distX * distX + distY * distY));
                }
            }
            // 간선 기준 오름차순 정렬
//            edgeList.sort(null);
            Collections.sort(edgeList);
            // 정점 초기화
            make();
            // 가중치가 낮은 간선부터 선택하면서 트리에 추가
            int cnt = 0;
            long res = 0;
            for (Edge edge : edgeList) {
                // 싸이클이 형성되지 않으면
                if(union(edge.from, edge.to)) {
                    // 간선 사용
                    res += edge.w;
                    if(++cnt == N - 1) break;
                }
            }
            // 총 환경 부담금을 최소로 지불하며, N개의 모든 섬을 연결할 수 있는 교통 시스템을 설계
            System.out.println("#" + tc + " " + Math.round(res * E));
        }
    }
 
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        // 사이클이 형성되면
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
 
    private static int find(int a) {
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
 
    private static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }    
    
}