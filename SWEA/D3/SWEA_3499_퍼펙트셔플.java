import java.io.*;
import java.util.*;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<String> cardLeft = new ArrayList<>();
			ArrayList<String> cardRight = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			if (N % 2 == 0) {
				for (int i = 0; i < N; i++) {
					if (i < N / 2) {
						cardLeft.add(st.nextToken());
					} else {
						cardRight.add(st.nextToken());
					}
				}
			} else {
				for (int i = 0; i < N; i++) {
					if (i <= N / 2) {
						cardLeft.add(st.nextToken());
					} else {
						cardRight.add(st.nextToken());
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < cardRight.size(); i++) {
				sb.append(cardLeft.get(i)).append(" ");
				sb.append(cardRight.get(i)).append(" ");
			}
			if (N % 2 == 1) {
				sb.append(cardLeft.get(N / 2));
			}
			System.out.println(sb);

		}
	}
}