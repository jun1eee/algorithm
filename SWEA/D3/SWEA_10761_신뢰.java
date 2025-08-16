import java.io.*;
import java.util.*;

public class SWEA_10761_신뢰 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String[] arr = new String[2 * N];
			for (int i = 0; i < 2 * N; i++) {
				arr[i] = st.nextToken();
			}

			int oPos = 1;
			int bPos = 1;
			int time = 0;
			int oTime = 0;
			int bTime = 0;

			for (int i = 0; i < 2 * N; i += 2) {
				String robot = arr[i];
				int target = Integer.parseInt(arr[i + 1]);

				if (robot.equals("O")) {
					int moveTime = Math.abs(target - oPos) + 1;
					oTime += moveTime;
					if (oTime > time) {
						time = oTime;
					} else {
						time++;
						oTime = time;
					}
					oPos = target;
				} else if (robot.equals("B")) {
					int moveTime = Math.abs(target - bPos) + 1;
					bTime += moveTime;
					if (bTime > time) {
						time = bTime;
					} else {
						time++;
						bTime = time;
					}
					bPos = target;
				}
			}
			System.out.println("#" + t + " " + time);
		}
	}
}
