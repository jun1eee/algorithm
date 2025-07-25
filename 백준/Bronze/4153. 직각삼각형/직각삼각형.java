import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[3];
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;
			Arrays.sort(arr);

			if (arr[2] * arr[2] == arr[1] * arr[1] + arr[0] * arr[0])
				System.out.println("right");
			else
				System.out.println("wrong");
		}

	}
}
