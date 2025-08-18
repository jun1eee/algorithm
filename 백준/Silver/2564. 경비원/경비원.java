import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로
        int t = Integer.parseInt(br.readLine());   // 상점 개수
        
        // 각 위치를 시계방향 둘레상의 거리로 변환하는 함수
        int[] positions = new int[t + 1]; // 상점들 + 동근이 위치
        
        for (int i = 0; i < t + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            
            if (direction == 1) { // 북쪽
                positions[i] = distance;
            } else if (direction == 2) { // 남쪽  
                positions[i] = N + M + (N - distance);
            } else if (direction == 3) { // 서쪽
                positions[i] = 2 * N + 2 * M - distance;
            } else { // 동쪽 (direction == 4)
                positions[i] = N + distance;
            }
        }
        
        int donggeunPos = positions[t]; // 동근이 위치
        int totalDistance = 0;
        int perimeter = 2 * (N + M); // 전체 둘레
        
        for (int i = 0; i < t; i++) {
            int shopPos = positions[i];
            
            // 시계방향 거리
            int clockwise = Math.abs(donggeunPos - shopPos);
            // 반시계방향 거리
            int counterClockwise = perimeter - clockwise;
            
            // 최단 거리 선택
            totalDistance += Math.min(clockwise, counterClockwise);
        }
        
        System.out.println(totalDistance);
    }
}