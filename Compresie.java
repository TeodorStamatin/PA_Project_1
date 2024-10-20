import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Compresie {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("compresie.in"));
			PrintWriter writer = new PrintWriter(new File("compresie.out"))) {

			int n = sc.nextInt();
			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = sc.nextInt();
			}

			int k = sc.nextInt();
			int[] B = new int[k];
			for (int i = 0; i < k; i++) {
				B[i] = sc.nextInt();
			}

			int[] dp = new int[n];
			int i = 0;
			int j = 0;
			int sumA = 0;
			int sumB = 0;
			int x = 0;
			while (i < n && j < k) {
				if (sumA + A[i] < sumB + B[j]) {
					sumA += A[i];
					i++;
				} else if (sumA + A[i] > sumB + B[j]) {
					sumB += B[j];
					j++;
				} else {
					dp[x] = sumA;
					x++;
					sumA = 0;
					sumB = 0;
					i++;
					j++;
				}
			}

			if (x == 0 || (i != n || j != k)) {
				writer.println(-1);
			} else {
				writer.println(x);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
