import java.util.*;
import java.io.*;
class Solution {
    public static int[][] dist;
    public static int[] dr = {-1,1,0,0};
    public static int[] dc = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = bfs(maps);;
        return answer;
    }
    public int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        dist = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        dist[0][0] = 1;
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == n-1 && c == m-1) {
                return dist[r][c];
            }
            for (int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr<0 || nc<0 || nr>=n || nc>=m) continue;
                if (maps[nr][nc] == 1 && dist[nr][nc] == 0){
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                }
                
            }
        }
        return -1;
    }
}