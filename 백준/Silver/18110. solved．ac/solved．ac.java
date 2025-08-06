import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		if (N == 0) {
			System.out.println(0);
		} else {
			int minus = (int) Math.round(N * 0.15);
			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			for (int i = minus; i < N-minus; i++) {
				sum += arr[i];
			}
			System.out.println(Math.round((double)sum/(N-2*minus)));		
		}	
	}
}
