import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 4; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());

            // 1) 떨어짐 (한 축이라도 간격이 존재)
            if (x2 < X1 || X2 < x1 || y2 < Y1 || Y2 < y1) {
                sb.append('d');
            }
            // 2) 점에서 만남 (양 축 모두 경계가 정확히 일치)
            else if ((x2 == X1 || X2 == x1) && (y2 == Y1 || Y2 == y1)) {
                sb.append('c');
            }
            // 3) 선분에서 만남 (한 축만 경계가 일치, 다른 축은 겹침)
            else if (x2 == X1 || X2 == x1 || y2 == Y1 || Y2 == y1) {
                sb.append('b');
            }
            // 4) 내부 영역 겹침
            else {
                sb.append('a');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
