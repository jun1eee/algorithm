import java.io.*;
import java.util.*;

/**
 * 그래프 탐색 : DFS, BFS(2차원 배열, 최단거리) DFS stack : 반복문, 재귀함수(장점 : 지금까지의 연산결과를 가지고
 * 다니자, 중복연산을 줄임)
 */
public class Solution {
	static int T;
	static int dayFee, monthFee, threeFee, yearFee;
	private static int minVal;
	static int[] plan; // 1~12월 이용일수
	static int[] cost; // 1~12월 각 달의 최소(일권 vs 월권)
	static int[] memo; // memo[i] = i월부터 최소 비용

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dayFee = Integer.parseInt(st.nextToken());
			monthFee = Integer.parseInt(st.nextToken());
			threeFee = Integer.parseInt(st.nextToken());
			yearFee = Integer.parseInt(st.nextToken());

			plan = new int[13]; // 1~12월
			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= 12; m++)
				plan[m] = Integer.parseInt(st.nextToken());
			
			minVal = yearFee;
			
			dfs(1,0);
			
			out.append('#').append(tc).append(' ').append(minVal).append('\n');
		}

		System.out.print(out.toString());
	}

//	매달 선택할 수 있는 구매옵션 선택 후 다음 달로 넘어가는 재귀함수
//	month 달의 선택하기, val : 이전 달까지 지불한 이용권 비용
	public static void dfs(int m, int val) {
		if (minVal <= val) return; // 가지치기
//    	if () // 종료 파트
		if (m > 12) {
			if (minVal > val) {
				minVal = val;
			}
			return;
		}
		if (plan[m] == 0) {
			dfs(m+1, val); // 다음 달
			
		}
		dfs(m + 1, dayFee*plan[m] + val); // 1일
		dfs(m + 1, monthFee + val); // 1달
		dfs(m + 3, threeFee + val); // 3달
//		dfs(m + 12, yearFee + val); // 1년
	}
}
