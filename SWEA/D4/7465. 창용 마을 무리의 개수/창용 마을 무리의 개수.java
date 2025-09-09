import java.io.*;
import java.util.*;

public class Solution {
	private static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1]; // 0 안씀
			makeSet(N);
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
			}
			int cnt = 0;
			for (int i = 1; i < p.length; i++) {
				if (p[i] == i) cnt++;
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
//	x그룹과 y그룹 합치기
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
//		if (px == py) { // 이미 같은 집합, 근데 또 하비는 작업을 한다? 사이클이 발생한다.
//		}
		p[py] = px;
	}

	private static int findSet(int x) {
		if (p[x] == x) return x;
		else return p[x] = findSet(p[x]); // Path compression
	}

//	1~n 값을 원소로 갖는 집합 생성하기
	private static void makeSet(int n) {
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
	}
}
