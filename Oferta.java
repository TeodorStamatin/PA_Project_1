import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Oferta {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new File("oferta.in"));
			PrintWriter writer = new PrintWriter(new File("oferta.out"))) {

			int n = sc.nextInt();
			int k = sc.nextInt();

			int[] products = new int[n];
			for (int i = 0; i < n; i++) {
				products[i] = sc.nextInt();
			}

			double[] dp = new double[n];
			double single;
			double twins;
			double triplets;
			switch (n) {
				case 1:
					dp[0] = products[0];
					break;
				case 2:
					dp[0] = products[0];
					dp[1] = products[0] + products[1] - Math.min(products[0],
							products[1]) / 2.0;
					break;
				case 3:
					dp[0] = products[0];
					dp[1] = products[0] + products[1] - Math.min(products[0],
							products[1]) / 2.0;
					single = dp[1] + products[2];
					twins = products[0] + products[2] + products[1]
							- Math.min(products[1], products[2]) / 2.0;
					triplets = products[0] + products[1] + products[2]
							- Math.min(products[0], Math.min(products[1], products[2]));
					dp[2] = Math.min(single, Math.min(twins, triplets));
					break;
				default:
					dp[0] = products[0];
					dp[1] = products[0] + products[1] - Math.min(products[0],
							products[1]) / 2.0;
					single = dp[1] + products[2];
					twins = products[0] + products[1] + products[2]
							- Math.min(products[1], products[2]) / 2.0;
					triplets = products[0] + products[1] + products[2]
							- Math.min(products[0], Math.min(products[1], products[2]));
					dp[2] = Math.min(single, Math.min(twins, triplets));
					for (int i = 3; i < n; i++) {
						{
							single = dp[i - 1] + products[i];
							twins = dp[i - 2] + products[i - 1] + products[i]
									- Math.min(products[i - 1], products[i]) / 2.0;
							triplets = dp[i - 3] + products[i - 2] + products[i - 1] + products[i]
									- Math.min(products[i - 2], Math.min(products[i - 1],
									products[i]));
							dp[i] = Math.min(single, Math.min(twins, triplets));
						}
					}
					break;
			}

			writer.printf("%.2f", dp[n - 1]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}